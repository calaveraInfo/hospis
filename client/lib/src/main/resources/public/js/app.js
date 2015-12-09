var Menu = React.createClass({
	getInitialState: function() {
		return {
			menuItems: [ { text: 'Login', href: '#' } ]
		};
	},
	render: function() {
		var menuItems = this.state.menuItems.map(function (menuItem) {
			return (
				<a href={menuItem.href} key={menuItem.text}>
					{menuItem.text}
				</a>
			);
		});
		return (
			<nav className="navbar navbar-inverse navbar-fixed-top">
				<div className="container">
					<div className="navbar-header">
						<button type="button" className="navbar-toggle collapsed" data-toggle="collapse"
							data-target="#navbar" aria-expanded="false" aria-controls="navbar">
							<span className="sr-only">Toggle navigation</span>
							<span className="icon-bar"></span>
							<span className="icon-bar"></span>
							<span className="icon-bar"></span>
						</button>
						<span className="navbar-brand">Hospis</span>
					</div>
					<div id="navbar" className="collapse navbar-collapse">
						<ul className="nav navbar-nav">
							<li className="active">
								{menuItems}
							</li>
						</ul>
					</div>
				</div>
			</nav>
		);
	}
});
 
var TextInput = React.createClass({
	render: function() {
		return (
			<div className="row">
				<div className="col-sm-4 col-md-2">
					<label htmlFor={this.props.inputId}>Vstup</label>
				</div>
				<div className="col-sm-8 col-md-10">
					<input type="text" id={this.props.inputId} className="form-control" placeholder="text"
						onChange={e => {this.props.inputStream.onNext({id: this.props.inputId, value: e.target.value});}} />
				</div>
			</div>
		);
	}
});
 
var Login = React.createClass({
	inputStream: new Rx.Subject(),
	submissionStream: new Rx.Subject(),
	componentWillMount: function () {
		this.submissionStream
			.withLatestFrom(
				this.inputStream
					.scan(new (Immutable.Record({user: '', password: ''}))(), (form, input) => form.set(input.id, input.value)),
				(clickEvent, formValue) => formValue)
			.flatMap(credentials => Rx.Observable.fromPromise(jQuery.post(window.location.href, credentials.toObject())))
			.filter(authentication => authentication.user ? true : false)
			.map(authentication => authentication.user)
			.subscribe(this.props.loginStream);
	},
	render: function() {
		return (
			<form className="login" onSubmit={e => {e.preventDefault(); this.submissionStream.onNext(e);} }>
				<TextInput inputId="user" ref="loginUser" inputStream={this.inputStream}/>
				<TextInput inputId="password" ref="loginPassword" inputStream={this.inputStream} />
				<button type="submit" className="btn btn-primary">Login</button>
			</form>
		);
	}
});

var LogedInUser = React.createClass({
	componentWillMount: function () {
		this.props.loggedUserStream.subscribeOnNext(loggedUser => { this.setState({user: loggedUser}); });
	},
	render: function() {
		return (
			<div>
				{this.state.user}
			</div>
		);
	}
});

var App = React.createClass({
	loginStream: new Rx.BehaviorSubject('xxx'),
	render: function() {
		return (
			<div>
				<Menu />
				<div className="container">
					<LogedInUser loggedUserStream={this.loginStream}/>
					<h1>Hospis login</h1>
					<Login loginStream={this.loginStream} />
				</div>
			</div>
		);
	}
});
 
React.render(
	<App />,
	document.body
);