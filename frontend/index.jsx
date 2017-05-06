import React from 'react';
import { render } from 'react-dom';
import { renderToString } from 'react-dom/server';
import App from './components/app/app';
import store from './state';

if (typeof window !== 'undefined' && typeof document !== 'undefined' && typeof document.createElement === 'function') {
    window.renderClient = (state) => {
        render (
            <App />,
            document.getElementById ('root')
        );
    }
} else {
    console.log("SERVER!!!");
    global.renderServer = () => {
        return renderToString (
            <App />
        );
    };
}