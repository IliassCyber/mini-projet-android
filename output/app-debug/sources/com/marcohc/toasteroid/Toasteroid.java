package com.marcohc.toasteroid;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public class Toasteroid {
    private static final int DEFAULT_GRAVITY = 80;
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    private static Toast myToast;

    public enum STYLES {
        SUCCESS,
        INFO,
        WARNING,
        ERROR,
        DELETE
    }

    public static void show(Activity activity, String message, STYLES style) {
        show(activity, message, style, 0, 80);
    }

    public static void show(Activity activity, String message, STYLES style, int duration) {
        show(activity, message, style, duration, 80);
    }

    public static void show(Activity activity, int message, STYLES style) {
        show(activity, message, style, 0, 80);
    }

    public static void show(Activity activity, int message, STYLES style, int duration) {
        show(activity, message, style, duration, 80);
    }

    public static void show(Activity activity, int message, STYLES style, int duration, int gravity) {
        show(activity, activity.getString(message), style, duration, gravity);
    }

    public static void show(Activity activity, String message, STYLES style, int duration, int gravity) {
        View toastView = activity.getLayoutInflater().inflate(R.layout.toasteroid_layout, (ViewGroup) null);
        ImageView toastImage = (ImageView) toastView.findViewById(R.id.toastImage);
        TextView toastMessage = (TextView) toastView.findViewById(R.id.toastMessage);
        ViewGroup toastContainer = (ViewGroup) toastView.findViewById(R.id.toastContainer);
        int marginBottom = (int) activity.getResources().getDimension(R.dimen.padding);
        toastImage.setImageResource(getStyleIcon(style));
        ((GradientDrawable) toastContainer.getBackground()).setColor(activity.getResources().getColor(getStyleBackgroundColor(style)));
        toastMessage.setText(message);
        myToast = new Toast(activity);
        myToast.setDuration(duration);
        myToast.setMargin(0.0f, 0.0f);
        myToast.setGravity(gravity, 0, marginBottom);
        myToast.setView(toastView);
        myToast.show();
    }

    public static void dismiss() {
        Toast toast = myToast;
        if (toast != null) {
            toast.cancel();
            myToast = null;
        }
    }

    public static boolean isShown() {
        Toast toast = myToast;
        if (toast != null && toast.getView().isShown()) {
            return true;
        }
        return false;
    }

    private static int getStyleIcon(STYLES style) {
        switch (style) {
            case SUCCESS:
                int resourceId = R.drawable.ic_toasteroid_success;
                return resourceId;
            case INFO:
                int resourceId2 = R.drawable.ic_toasteroid_info;
                return resourceId2;
            case WARNING:
                int resourceId3 = R.drawable.ic_toasteroid_warning;
                return resourceId3;
            case ERROR:
                int resourceId4 = R.drawable.ic_toasteroid_error;
                return resourceId4;
            case DELETE:
                int resourceId5 = R.drawable.ic_toasteroid_delete;
                return resourceId5;
            default:
                int resourceId6 = R.drawable.ic_toasteroid_info;
                return resourceId6;
        }
    }

    private static int getStyleBackgroundColor(STYLES style) {
        switch (style) {
            case SUCCESS:
                int color = R.color.toasteroid_success;
                return color;
            case INFO:
                int color2 = R.color.toasteroid_info;
                return color2;
            case WARNING:
                int color3 = R.color.toasteroid_warning;
                return color3;
            case ERROR:
                int color4 = R.color.toasteroid_error;
                return color4;
            case DELETE:
                int color5 = R.color.toasteroid_deleted;
                return color5;
            default:
                int color6 = R.color.toasteroid_info;
                return color6;
        }
    }
}
