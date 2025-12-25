package com.google.firebase.analytics;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes2.dex */
public class GoogleAnalyticsServerPreviewActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        zzff.zzg(this, null, null, null, null).zzN(getIntent());
        finish();
    }
}
