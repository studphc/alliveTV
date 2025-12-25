package com.hisona.allive;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hisona.allive.BackgroundTask;
import com.hisona.allive.VersionChecker;
import io.reactivex.rxjava3.core.ObservableEmitter;

/* loaded from: classes2.dex */
public final class d0 extends BackgroundTask {
    public final String a;

    public d0(Activity activity, String str) {
        super(activity);
        this.a = str;
    }

    @Override // com.hisona.allive.BackgroundTask
    public final void doInBackground(ObservableEmitter observableEmitter) {
        try {
            String body = HttpRequest.get((CharSequence) this.a, true, new Object[0]).trustAllHosts().trustAllCerts().connectTimeout(10000).userAgent(VersionChecker.getStringById(this.mWeakReference.get(), R.string.USERAGENT)).body();
            if (isCancelled(observableEmitter)) {
                return;
            }
            if (body != null && body.length() != 0) {
                JsonObject asJsonObject = JsonParser.parseString(body).getAsJsonObject();
                JsonElement jsonElement = asJsonObject.get("LastVersion");
                if (jsonElement != null && !jsonElement.isJsonNull()) {
                    VersionChecker.e = jsonElement.getAsString();
                }
                JsonElement jsonElement2 = asJsonObject.get("VersionInfo");
                if (jsonElement2 != null && !jsonElement2.isJsonNull()) {
                    VersionChecker.f = jsonElement2.getAsString();
                }
                observableEmitter.onNext(new BackgroundTask.ProgressOrResult(-1, 1));
                observableEmitter.onComplete();
                return;
            }
            observableEmitter.onNext(new BackgroundTask.ProgressOrResult(-1, -2));
            observableEmitter.onComplete();
        } catch (Exception e) {
            if (isCancelled(observableEmitter)) {
                Log.e("VersionChecker", "GetLatestVersion Error: RESULT_CANCEL");
                return;
            }
            e.printStackTrace();
            Log.e("VersionChecker", "GetLatestVersion Error: " + e.getMessage());
            observableEmitter.onError(new Throwable());
        }
    }

    @Override // com.hisona.allive.BackgroundTask
    public final void onPostExecute(BackgroundTask.ProgressOrResult progressOrResult) {
        String str;
        final int i = 1;
        final int i2 = 0;
        Activity activity = this.mWeakReference.get();
        if (activity != null && !activity.isFinishing() && (str = VersionChecker.e) != null && str.length() > 0 && Double.parseDouble(VersionChecker.d) < Double.parseDouble(VersionChecker.e)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            VersionChecker.c = new c0(activity, VersionChecker.e);
            builder.setTitle(activity.getResources().getString(R.string.update_title_str));
            builder.setMessage(String.format(activity.getResources().getString(R.string.update_version_str), VersionChecker.e) + "\n\n" + VersionChecker.f);
            builder.setCancelable(false);
            builder.setPositiveButton(activity.getResources().getString(R.string.ok_str), new DialogInterface.OnClickListener() { // from class: r13
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    switch (i2) {
                        case 0:
                            dialogInterface.dismiss();
                            try {
                                VersionChecker.c.execute();
                                return;
                            } catch (Exception e) {
                                Log.e("VersionChecker", "showUpdateDialog Error: " + e.getMessage());
                                return;
                            }
                        default:
                            dialogInterface.cancel();
                            return;
                    }
                }
            });
            builder.setNegativeButton(activity.getResources().getString(R.string.cancel_str), new DialogInterface.OnClickListener() { // from class: r13
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    switch (i) {
                        case 0:
                            dialogInterface.dismiss();
                            try {
                                VersionChecker.c.execute();
                                return;
                            } catch (Exception e) {
                                Log.e("VersionChecker", "showUpdateDialog Error: " + e.getMessage());
                                return;
                            }
                        default:
                            dialogInterface.cancel();
                            return;
                    }
                }
            });
            builder.show();
            if (!VersionChecker.checkPermission(activity)) {
                VersionChecker.requestPermission(activity);
            }
        }
    }

    @Override // com.hisona.allive.BackgroundTask
    public final void onPreExecute() {
    }
}
