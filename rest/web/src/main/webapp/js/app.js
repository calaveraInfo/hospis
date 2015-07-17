var Menu = React.createClass({
	render: function() {
		var menuItems = this.props.menuItems.map(function (menuItem) {
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
	getValue: function () {
		return React.findDOMNode(this.refs.inputField).value;
	},
	render: function() {
        return (
            <div className="row">
				<div className="col-sm-4 col-md-2">
					<label htmlFor={this.props.inputId}>Vstup</label>
				</div>
				<div className="col-sm-8 col-md-10">
					<input type="text" id={this.props.inputId} className="form-control" placeholder="text" ref="inputField" />
				</div>
			</div>
        );
    }
});
 
var Login = React.createClass({
	onLogin: function(e) {
		e.preventDefault();
		if (this.props.onLogin) {
			this.props.onLogin({
				user: this.refs.loginUser.getValue(),
				password: this.refs.loginPassword.getValue()
			});
		}
	},
    render: function() {
        return (
            <form className="login" onSubmit={this.onLogin}>
            	<TextInput inputId="loginUser" ref="loginUser"/>
            	<TextInput inputId="loginPassword" ref="loginPassword" />
				<button type="submit" className="btn btn-primary">Login</button>
			</form>
        );
    }
});
 
var App = React.createClass({
	getInitialState: function() {
		return {
			menuItems: [ { text: 'Login', href: '#' } ],
			loginData: {
				user: "jnovak",
				password: "he5l0"
			}
		};
	},
	handleLogin: function(loginData) {
		this.setState({ menuItems: [ { text: loginData.user, href: '#' } ], loginData: loginData });
	},
    render: function() {
        return (
            <div>
				<Menu menuItems={this.state.menuItems} />
				<div className="container">
					<h1>Hospis login</h1>
					<Login onLogin={this.handleLogin}/>
				</div>
			</div>
        );
    }
});
 
React.render(
    <App />,
    document.body
);