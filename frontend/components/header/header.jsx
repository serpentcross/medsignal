import React from 'react'
import styles from './header.css';

class Header extends React.Component {
    render() {
        return (
            <div className={styles.bHeader}>
                <LogoType />
            </div>
        );
    }
}

class LogoType extends React.Component {
    render() {
        return (
            <div className={styles.eMainLogo} />
        )
    }
}

export default Header;