package androidx.core.view.autofill;

import android.view.autofill.AutofillId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p000.AbstractC1571n3;

/* loaded from: classes.dex */
public class AutofillIdCompat {

    /* renamed from: a */
    public final Object f3971a;

    public AutofillIdCompat(AutofillId autofillId) {
        this.f3971a = autofillId;
    }

    @NonNull
    @RequiresApi(26)
    public static AutofillIdCompat toAutofillIdCompat(@NonNull AutofillId autofillId) {
        return new AutofillIdCompat(autofillId);
    }

    @NonNull
    @RequiresApi(26)
    public AutofillId toAutofillId() {
        return AbstractC1571n3.m6296t(this.f3971a);
    }
}
