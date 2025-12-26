package p000;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import java.util.HashMap;

/* renamed from: s5 */
/* loaded from: classes.dex */
public final class C1786s5 extends ActivityResultLauncher {

    /* renamed from: a */
    public final /* synthetic */ int f26243a;

    /* renamed from: b */
    public final /* synthetic */ String f26244b;

    /* renamed from: c */
    public final /* synthetic */ ActivityResultContract f26245c;

    /* renamed from: d */
    public final /* synthetic */ ActivityResultRegistry f26246d;

    public /* synthetic */ C1786s5(ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract activityResultContract, int i) {
        this.f26243a = i;
        this.f26246d = activityResultRegistry;
        this.f26244b = str;
        this.f26245c = activityResultContract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public final ActivityResultContract getContract() {
        switch (this.f26243a) {
            case 0:
                return this.f26245c;
            default:
                return this.f26245c;
        }
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public final void launch(Object obj, ActivityOptionsCompat activityOptionsCompat) {
        switch (this.f26243a) {
            case 0:
                ActivityResultRegistry activityResultRegistry = this.f26246d;
                HashMap hashMap = activityResultRegistry.f538b;
                String str = this.f26244b;
                Integer num = (Integer) hashMap.get(str);
                ActivityResultContract activityResultContract = this.f26245c;
                if (num != null) {
                    activityResultRegistry.f540d.add(str);
                    try {
                        activityResultRegistry.onLaunch(num.intValue(), activityResultContract, obj, activityOptionsCompat);
                        return;
                    } catch (Exception e) {
                        activityResultRegistry.f540d.remove(str);
                        throw e;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            default:
                ActivityResultRegistry activityResultRegistry2 = this.f26246d;
                HashMap hashMap2 = activityResultRegistry2.f538b;
                String str2 = this.f26244b;
                Integer num2 = (Integer) hashMap2.get(str2);
                ActivityResultContract activityResultContract2 = this.f26245c;
                if (num2 != null) {
                    activityResultRegistry2.f540d.add(str2);
                    try {
                        activityResultRegistry2.onLaunch(num2.intValue(), activityResultContract2, obj, activityOptionsCompat);
                        return;
                    } catch (Exception e2) {
                        activityResultRegistry2.f540d.remove(str2);
                        throw e2;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public final void unregister() {
        switch (this.f26243a) {
            case 0:
                this.f26246d.m151b(this.f26244b);
                return;
            default:
                this.f26246d.m151b(this.f26244b);
                return;
        }
    }
}
