import React from 'react'
import styles from './app.css';
import Header from '../header/header';

class App extends React.Component {
    render() {
        return (
            <div className={styles.bPageLine}>
                <Header />
            </div>
        );
    }
}

export default App;
