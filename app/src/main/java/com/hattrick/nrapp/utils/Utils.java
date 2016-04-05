package com.hattrick.nrapp.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.hattrick.nrapp.R;

/**
 * Created by gastonkosut on 4/5/16.
 */
public class Utils {

    public static ProgressDialog createProgressDialog(Context ctx){
        ProgressDialog mDialogProgress = new ProgressDialog(ctx, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
        mDialogProgress.setMessage(ctx.getResources().getString(R.string.progress_bar_message));
        mDialogProgress.setCancelable(false);
        mDialogProgress.setInverseBackgroundForced(false);
        return  mDialogProgress;
    }
}
