package p000;

import androidx.leanback.widget.picker.DatePicker;
import androidx.leanback.widget.picker.PickerColumn;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;

/* renamed from: uy */
/* loaded from: classes.dex */
public final class RunnableC1889uy implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f27525a;

    /* renamed from: b */
    public final boolean f27526b;

    /* renamed from: c */
    public final Object f27527c;

    public /* synthetic */ RunnableC1889uy(Object obj, int i, boolean z) {
        this.f27525a = i;
        this.f27527c = obj;
        this.f27526b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        boolean z3;
        Object obj;
        Object obj2;
        switch (this.f27525a) {
            case 0:
                DatePicker datePicker = (DatePicker) this.f27527c;
                int[] iArr = {datePicker.f6354v, datePicker.f6353u, datePicker.f6355w};
                boolean z4 = true;
                boolean z5 = true;
                for (int i = 2; i >= 0; i--) {
                    int i2 = iArr[i];
                    if (i2 >= 0) {
                        int i3 = DatePicker.f6345D[i];
                        PickerColumn columnAt = datePicker.getColumnAt(i2);
                        boolean z6 = false;
                        if (z4) {
                            int i4 = datePicker.f6358z.get(i3);
                            if (i4 != columnAt.getMinValue()) {
                                columnAt.setMinValue(i4);
                                z = true;
                            }
                            z = false;
                        } else {
                            int actualMinimum = datePicker.f6347B.getActualMinimum(i3);
                            if (actualMinimum != columnAt.getMinValue()) {
                                columnAt.setMinValue(actualMinimum);
                                z = true;
                            }
                            z = false;
                        }
                        if (z5) {
                            int i5 = datePicker.f6346A.get(i3);
                            if (i5 != columnAt.getMaxValue()) {
                                columnAt.setMaxValue(i5);
                                z2 = true;
                            }
                            z2 = false;
                        } else {
                            int actualMaximum = datePicker.f6347B.getActualMaximum(i3);
                            if (actualMaximum != columnAt.getMaxValue()) {
                                columnAt.setMaxValue(actualMaximum);
                                z2 = true;
                            }
                            z2 = false;
                        }
                        boolean z7 = z | z2;
                        if (datePicker.f6347B.get(i3) == datePicker.f6358z.get(i3)) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        z4 &= z3;
                        if (datePicker.f6347B.get(i3) == datePicker.f6346A.get(i3)) {
                            z6 = true;
                        }
                        z5 &= z6;
                        if (z7) {
                            datePicker.setColumnAt(iArr[i], columnAt);
                        }
                        datePicker.setColumnValue(iArr[i], datePicker.f6347B.get(i3), this.f27526b);
                    }
                }
                return;
            case 1:
                is0 is0Var = (is0) this.f27527c;
                MpscLinkedQueue mpscLinkedQueue = is0Var.f16960b;
                if (this.f27526b) {
                    obj = is0.f20245q;
                } else {
                    obj = is0.f20246r;
                }
                mpscLinkedQueue.offer(obj);
                is0Var.mo4752c();
                return;
            default:
                k02 k02Var = (k02) this.f27527c;
                MpscLinkedQueue mpscLinkedQueue2 = k02Var.f17503b;
                if (this.f27526b) {
                    obj2 = k02.f20706p;
                } else {
                    obj2 = k02.f20707q;
                }
                mpscLinkedQueue2.offer(obj2);
                k02Var.mo4898c();
                return;
        }
    }
}
