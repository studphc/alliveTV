package p000;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.gms.common.GoogleApiAvailability;

/* loaded from: classes.dex */
public final class x73 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ Activity f28458a;

    /* renamed from: b */
    public final /* synthetic */ int f28459b;

    /* renamed from: c */
    public final /* synthetic */ ActivityResultLauncher f28460c;

    /* renamed from: d */
    public final /* synthetic */ GoogleApiAvailability f28461d;

    public x73(GoogleApiAvailability googleApiAvailability, Activity activity, int i, ActivityResultLauncher activityResultLauncher) {
        this.f28461d = googleApiAvailability;
        this.f28458a = activity;
        this.f28459b = i;
        this.f28460c = activityResultLauncher;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        PendingIntent errorResolutionPendingIntent = this.f28461d.getErrorResolutionPendingIntent(this.f28458a, this.f28459b, 0);
        if (errorResolutionPendingIntent == null) {
            return;
        }
        this.f28460c.launch(new IntentSenderRequest.Builder(errorResolutionPendingIntent.getIntentSender()).build());
    }
}
