var gulp = require('gulp'),
    gutil = require("gulp-util"),
    replace = require('gulp-replace'),
    webpack = require('webpack'),
    WebpackDevServer = require("webpack-dev-server"),
    webpackConfigFunc = require("./webpack.config.js"),
    buildConfig = require("./api-config.js")();

function checkBuild(err, stats, processName) {
    var json = stats.toJson();
    if (json.errors.length > 0) {
        console.log("errors=", json.errors);
        throw new gutil.PluginError(processName, json.errors);
    }
}

gulp.task("webpack:build", function (callback) {
    var devCompiler = getWebpackConfiguration();
    devCompiler.run(function (err, stats) {
        checkBuild(err, stats, "webpack:build");
        gulp.src('./index.html').pipe(gulp.dest("build"));
        callback();
    });
});

gulp.task("webpack-dev-server", function () {
    var devCompiler = getWebpackConfiguration();

    // Start a webpack-dev-server
    new WebpackDevServer(devCompiler, {
        publicPath: "/build",
        stats: {
            colors: true
        }
    }).listen(9401, "localhost", function (err) {
        gutil.log("[webpack-dev-server]", "http://localhost:9401/webpack-dev-server/build");
    });
});

function getWebpackConfiguration() {
    var buildProps = {
        cache: true,
        context_path: "./",
        target_dir: "build/",
        bundle_filename: "app.js",
        chunk_filename: "[chunkname].js",
        cssFileName: "style.css"
    };

    var webpackConfig = Object.create(webpackConfigFunc(buildProps));
    webpackConfig.debug = true;

    webpackConfig.plugins = webpackConfig.plugins.concat(
        new webpack.DefinePlugin(
            {
                API_HOST: JSON.stringify(buildConfig.API)
            }
        )
    );

    return webpack(webpackConfig);
}

gulp.task('webpack', ['webpack:build', 'webpack-dev-server']);
gulp.task('default', ["webpack"]);