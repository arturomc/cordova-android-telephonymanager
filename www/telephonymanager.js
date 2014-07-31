var TelephonyManager = function(){};



TelephonyManager.prototype.getDeviceId = function(onSuccess, onFail) {
    return cordova.exec(onSuccess, onFail, 'TelephonyManagerPlugin', 'getDeviceId', []);
};

if(!window.plugins) {
    window.plugins = {};
}

if (!window.plugins.telephony) {
    window.plugins.telephony = new TelephonyManager();
}