var path = require ('path');
var ExtractTextPlugin = require ('extract-text-webpack-plugin');

var clientSrcPath = path.resolve (__dirname, 'frontend');
var serverSrcPath = path.resolve (__dirname, 'src/main/resources/static');


module.exports = {

    entry: clientSrcPath + '/index.jsx',

    output: {
        path: serverSrcPath,
        filename: 'bundle.js'
    },

    plugins: [
        new ExtractTextPlugin('styles.css'),
    ],

    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
                query: {
                    presets:['es2015', 'react', 'stage-2']
                }
            },
            {
                test: /.css/,
                exclude: /node_modules/,
                use: ExtractTextPlugin.extract(
                    {
                        fallback: 'style-loader',
                        use: [
                            {
                                loader: 'css-loader',
                                options: { modules: true }
                            }
                        ]
                    }
                )
            },
            {
                test: /\.(png|jpg|svg|gif)$/,
                use: {
                    loader: 'url-loader'
                },
            },
        ]
    },
    resolve: {
        extensions: ['.js', '.jsx']
    }
};