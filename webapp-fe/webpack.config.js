var path = require("path");
var webpack = require("webpack");
var ExtractTextPlugin = require("extract-text-webpack-plugin");

module.exports = function (props) {
    return {
        cache: props.cache,
        useMemoryFs: true,
        progress: true,
        watchDelay: 300,
        context: path.join(__dirname, props.context_path),

        entry: [
            './js/Index.jsx'
        ],

        output: {
            path: path.join(__dirname, props.target_dir),
            filename: props.bundle_filename,
            chunkFilename: props.chunk_filename
        },
        module: {
            loaders: [
                {test: /\.(png|jpg|gif)$/, loader: "url?limit=50&name=img/[name].[ext]"},
                {test: /\.js[x]$/, loader: "babel?stage=0"},
                {test: /\.css$/, loader: "style!css"},
                {test: /\.less$/, loader: "style!css!less"},
                {test: /\.scss$/, loader: ExtractTextPlugin.extract("css!sass")},
                {test: /\.(woff|woff2)$/, loader: "url-loader?limit=10000&name=fonts/[name].[ext]&minetype=application/font-woff"},
                {test: /\.(ttf|eot|svg)$/, loader: "file-loader?name=img/[name].[ext]"}
            ]
        },
        plugins: [
            new ExtractTextPlugin(props.cssFileName),
            new webpack.ProvidePlugin({
                jQuery: "jquery",
                $: "jquery"
            }),
            new webpack.ProvidePlugin({
                "React": "react"
            })
        ]
    }
};