package p000;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

/* renamed from: rt */
/* loaded from: classes.dex */
public final class C1773rt extends ActivityResultRegistry {

    /* renamed from: h */
    public final /* synthetic */ ComponentActivity f26126h;

    public C1773rt(ComponentActivity componentActivity) {
        this.f26126h = componentActivity;
    }

    @Override // androidx.activity.result.ActivityResultRegistry
    public final void onLaunch(int i, ActivityResultContract activityResultContract, Object obj, ActivityOptionsCompat activityOptionsCompat) {
        Bundle bundle;
        Bundle bundle2;
        ComponentActivity componentActivity = this.f26126h;
        ActivityResultContract.SynchronousResult synchronousResult = activityResultContract.getSynchronousResult(componentActivity, obj);
        if (synchronousResult != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC1699pt(this, i, synchronousResult));
            return;
        }
        Intent createIntent = activityResultContract.createIntent(componentActivity, obj);
        if (createIntent.getExtras() != null && createIntent.getExtras().getClassLoader() == null) {
            createIntent.setExtrasClassLoader(componentActivity.getClassLoader());
        }
        if (createIntent.hasExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) {
            Bundle bundleExtra = createIntent.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            createIntent.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            bundle2 = bundleExtra;
        } else {
            if (activityOptionsCompat != null) {
                bundle = activityOptionsCompat.toBundle();
            } else {
                bundle = null;
            }
            bundle2 = bundle;
        }
        if (ActivityResultContracts.RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS.equals(createIntent.getAction())) {
            String[] stringArrayExtra = createIntent.getStringArrayExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS);
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            ActivityCompat.requestPermissions(componentActivity, stringArrayExtra, i);
            return;
        }
        if (ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST.equals(createIntent.getAction())) {
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) createIntent.getParcelableExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST);
            try {
                ActivityCompat.startIntentSenderForResult(componentActivity, intentSenderRequest.getIntentSender(), i, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle2);
                return;
            } catch (IntentSender.SendIntentException e) {
                new Handler(Looper.getMainLooper()).post(new RunnableC1736qt(this, i, e));
                return;
            }
        }
        ActivityCompat.startActivityForResult(componentActivity, createIntent, i, bundle2);
    }
}
