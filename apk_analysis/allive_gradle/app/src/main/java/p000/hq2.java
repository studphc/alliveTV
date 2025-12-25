package p000;

import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class hq2 {
    @DoNotInline
    /* renamed from: a */
    public static int m5123a(int i) {
        return SubscriptionManager.getSlotIndex(i);
    }
}
