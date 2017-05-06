import React from 'react'
import styles from './app.css';
import Header from '../header/header';
import store from './../../state';

class App extends React.Component {
    render() {
        return (
            <div className={styles.bPageLine}>
                <Header />
                <h1>H<MyButton val={'press me!'}/> <MyCounter/></h1>
            </div>
        );
    }
}

class MyButton extends React.Component {

    render() {
        return (<input type="button" value={this.props.val} onClick={this.doSomething.bind(this)}/>);
    }

    doSomething() {
        exampleMethod();
    }
}

class MyCounter extends React.Component {
    render() {
        return(<div id="myobj"></div>)
    }
}

store.subscribe(() => { document.getElementById("myobj").innerHTML = store.getState().counter; });
export default App;
