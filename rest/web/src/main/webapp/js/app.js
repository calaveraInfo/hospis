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
					<input type="text" id={this.props.inputId} ref="inputField" className="form-control" placeholder="text" />
				</div>
			</div>
        );
    }
});



var Login = React.createClass({
	handleLogin: function(e) {
		e.preventDefault();
		var user = this.refs.loginUser.getValue();//React.findDOMNode(this.refs.loginUser).value.trim();
		var password = this.refs.loginPassword.getValue();//React.findDOMNode(this.refs.loginPassword).value;
		if (!user || !password) {
		  return;
		}

		//React.findDOMNode(this.refs.loginUser).value = '';
		//React.findDOMNode(this.refs.loginPassword).value = '';
		this.props.onLoginSubmit({user: user, password: password});
	},

	observer: Rx.Observer.create(function(valueChanged) {
		log.info(valueChanged);
	}, function() {}, function() {}),

    render: function() {
        return (
            <form className="login" onSubmit={this.handleLogin}>
            	<TextInput ref="loginUser" inputId="loginUser" />
            	<TextInput ref="loginPassword" inputId="loginPassword" />
				<button type="submit" className="btn btn-primary">Login</button>
			</form>
        );
    }
});

var menuItems = [ { text: 'Login', href: '#' } ];

var App = React.createClass({
	getInitialState: function() {
		return {
			menuItems: menuItems,
			loginData: {
				user: "jnovak",
				password: "he5l0"
			}};
	},
	handleLogin: function(loginData) {
		this.setState({ menuItems: [ { text: loginData.user, href: '#' } ] });
	},
    render: function() {
        return (
            <div>
				<Menu menuItems={this.state.menuItems} />
				<div className="container">
					<h1>Hospis login</h1>
					<Login onLoginSubmit={this.handleLogin} />
				</div>
			</div>
        );
    }
});

React.render(
    <App />,
    document.body
);
