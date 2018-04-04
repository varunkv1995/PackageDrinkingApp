package comw.example.mdsaif.packagedrinkingapp.utils;

/**
 * Created by Md.Saif on 24-02-2018.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.text.format.DateFormat;
import android.view.Display;

import comw.example.mdsaif.packagedrinkingapp.activity.NavigationActivity;
import comw.example.mdsaif.packagedrinkingapp.activity.SplashActivity;


/**
 * Created by gunjit on 09/04/17.
 */

public class AppUtils {
    public static Point getDeviceDimensions(Activity context) {
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    public static int dpFromPx(final Context context, final float px) {
        return (int) (px / context.getResources().getDisplayMetrics().density);
    }

    public static int pxFromDp(final Context context, final float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    public static String convertDate(long dateInMilliseconds,String dateFormat) {
        return DateFormat.format(dateFormat, dateInMilliseconds).toString();
    }

    public static void logout(NavigationActivity context) {
        SharedPrefUtils.clearSharedPref(context);
        //Cart.getInstance((Cart.CartUpdateListener) context).clearCart();
        Intent i = new Intent(context, SplashActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(i);
        context.finish();

    }
}


