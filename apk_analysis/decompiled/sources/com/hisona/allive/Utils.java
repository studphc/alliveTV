package com.hisona.allive;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hisona.allive.SettingsData;
import defpackage.ye0;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class Utils {

    /* loaded from: classes2.dex */
    public enum Code {
        CodeStart,
        WavveSave,
        TvingSave,
        EtcSave,
        SettingsRequestCode,
        ServiceIntent_OK,
        ServiceIntent_Fail,
        ServiceIntent_Profile,
        NoAuthKey_err,
        NoVideoUrl_err,
        NoRight_err,
        FetchVideoUrl_OK,
        FavoritePlay,
        WavvePlay,
        TvingPlay
    }

    /* loaded from: classes2.dex */
    public enum Header {
        Wavve,
        Tving,
        Favorite,
        Etc
    }

    /* loaded from: classes2.dex */
    public enum SiteType {
        None,
        Wavve,
        Tving,
        Favorite
    }

    public static int convertDpToPixel(Context context, int i) {
        return Math.round(i * context.getResources().getDisplayMetrics().density);
    }

    public static void doFullScreen(Activity activity) {
        activity.getWindow().addFlags(1024);
        activity.getWindow().getDecorView().setSystemUiVisibility(3846);
    }

    public static String formatMillis(int i) {
        int i2 = i / 3600000;
        int i3 = i % 3600000;
        int i4 = i3 / 60000;
        int i5 = (i3 % 60000) / 1000;
        String str = "";
        if (i2 > 0) {
            str = ye0.l(i2, "", ":");
        }
        if (i4 >= 0) {
            if (i4 > 9) {
                str = str + i4 + ":";
            } else {
                str = str + "0" + i4 + ":";
            }
        }
        if (i5 > 9) {
            return str + i5;
        }
        return str + "0" + i5;
    }

    public static Point getDisplaySize(Activity activity) {
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        int systemBars;
        Insets insetsIgnoringVisibility;
        Rect bounds;
        int i;
        int i2;
        Rect bounds2;
        int i3;
        int i4;
        if (Build.VERSION.SDK_INT >= 30) {
            currentWindowMetrics = activity.getWindowManager().getCurrentWindowMetrics();
            windowInsets = currentWindowMetrics.getWindowInsets();
            systemBars = WindowInsets.Type.systemBars();
            insetsIgnoringVisibility = windowInsets.getInsetsIgnoringVisibility(systemBars);
            Point point = new Point();
            bounds = currentWindowMetrics.getBounds();
            int width = bounds.width();
            i = insetsIgnoringVisibility.left;
            int i5 = width - i;
            i2 = insetsIgnoringVisibility.right;
            point.x = i5 - i2;
            bounds2 = currentWindowMetrics.getBounds();
            int height = bounds2.height();
            i3 = insetsIgnoringVisibility.top;
            i4 = insetsIgnoringVisibility.bottom;
            point.y = (height - i3) - i4;
            return point;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Point point2 = new Point();
        point2.x = displayMetrics.widthPixels;
        point2.y = displayMetrics.heightPixels;
        return point2;
    }

    public static long getDuration(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str, new HashMap());
        return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
    }

    @NonNull
    public static String getExternalStorageDirectory(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            String absolutePath = externalFilesDir.getAbsolutePath();
            int indexOf = absolutePath.toLowerCase().indexOf("/android/data/");
            if (indexOf > 0) {
                return absolutePath.substring(0, indexOf);
            }
            return absolutePath;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            return externalStorageDirectory.getAbsolutePath();
        }
        return "";
    }

    public static boolean hasPermission(Context context, String str) {
        if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
            return true;
        }
        return false;
    }

    public static boolean parseSettingsData(String str, SettingsData settingsData) {
        boolean z;
        boolean z2;
        String str2;
        boolean z3;
        String str3;
        String str4;
        String str5;
        JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
        if (asJsonObject == null) {
            return false;
        }
        try {
            JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("a");
            if (asJsonObject2 != null) {
                SettingsData.WavveSettingsData wavveSettingsData = settingsData.mWavveSettings;
                if (asJsonObject2.get("a") != null) {
                    z3 = asJsonObject2.get("a").getAsBoolean();
                } else {
                    z3 = true;
                }
                wavveSettingsData.mEnable = z3;
                SettingsData.WavveSettingsData wavveSettingsData2 = settingsData.mWavveSettings;
                String str6 = "";
                if (asJsonObject2.get("b") == null) {
                    str3 = "";
                } else {
                    str3 = asJsonObject2.get("b").getAsString();
                }
                wavveSettingsData2.mId = str3;
                SettingsData.WavveSettingsData wavveSettingsData3 = settingsData.mWavveSettings;
                if (asJsonObject2.get("c") == null) {
                    str4 = "";
                } else {
                    str4 = asJsonObject2.get("c").getAsString();
                }
                wavveSettingsData3.mPassword = str4;
                if (asJsonObject2.get("d") != null) {
                    str5 = asJsonObject2.get("d").getAsString();
                } else {
                    str5 = "SD";
                }
                SettingsData.WavveSettingsData wavveSettingsData4 = settingsData.mWavveSettings;
                SettingsData.WavveQualityType wavveQualityType = wavveSettingsData4.mQualityType;
                wavveSettingsData4.mQualityType = SettingsData.WavveQualityType.valueOf(str5);
                SettingsData.WavveSettingsData wavveSettingsData5 = settingsData.mWavveSettings;
                if (asJsonObject2.get("e") != null) {
                    str6 = asJsonObject2.get("e").getAsString();
                }
                wavveSettingsData5.mProfile = str6;
            }
            JsonObject asJsonObject3 = asJsonObject.getAsJsonObject("b");
            if (asJsonObject3 != null) {
                SettingsData.TvingSettingsData tvingSettingsData = settingsData.mTvingSettings;
                if (asJsonObject3.get("a") != null) {
                    z2 = asJsonObject3.get("a").getAsBoolean();
                } else {
                    z2 = true;
                }
                tvingSettingsData.mEnable = z2;
                if (asJsonObject3.get("e") != null) {
                    str2 = asJsonObject3.get("e").getAsString();
                } else {
                    str2 = "HD";
                }
                SettingsData.TvingSettingsData tvingSettingsData2 = settingsData.mTvingSettings;
                SettingsData.TvingQualityType tvingQualityType = tvingSettingsData2.mQualityType;
                tvingSettingsData2.mQualityType = SettingsData.TvingQualityType.valueOf(str2);
            }
            JsonObject asJsonObject4 = asJsonObject.getAsJsonObject("c");
            if (asJsonObject4 != null) {
                SettingsData.EtcSettingsData etcSettingsData = settingsData.mEtcSettings;
                if (asJsonObject4.get("a") != null) {
                    z = asJsonObject4.get("a").getAsBoolean();
                } else {
                    z = true;
                }
                etcSettingsData.mLongPress = z;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String removeHTMLTag(String str) {
        if (str != null && !str.isEmpty()) {
            return str.replaceAll("\"", "").replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&nbsp;", " ").replaceAll("&amp;", "&").replaceAll("\n", " ").replaceAll("<br>", " ");
        }
        return null;
    }

    public static String removeQuote(String str) {
        if (str != null && !str.isEmpty()) {
            return str.replace("\"", "");
        }
        return null;
    }

    public static void showToast(Context context, String str) {
        Toast.makeText(context, str, 1).show();
    }

    public static void showToast(Context context, int i) {
        Toast.makeText(context, context.getString(i), 1).show();
    }
}
