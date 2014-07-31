package amc.blueribbon.cordova.TelephonyManager;

import org.json.JSONArray;
import android.content.Context;
import android.telephony.TelephonyManager;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;

public class TelephonyManagerPlugin extends CordovaPlugin {

    TelephonyManager telephony = null;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if(telephony == null) {
            telephony = TelephonyManager.get(cordova.getActivity());
        }

        String result = "";
        boolean returnState = false;
        if (action.equals("getDeviceId")) {
            TelephonyManager telephonyManager = (TelephonyManager) this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
            result = telephonyManager.getDeviceId();
            if (result == null) {
                callbackContext.error("could not retrieve IMEI");
            } else {
                callbackContext.success(result);
            }
            returnState = true;
        } else {
            returnState = false;
        }
        return returnState;
    }
}