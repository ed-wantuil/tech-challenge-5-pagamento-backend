function() {
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);

    var config= {};

    config.applicationUrl = 'http://localhost:' + (karate.properties['karate.port']);

    karate.log('karate host: ', config.applicationUrl);

    return config;
}
