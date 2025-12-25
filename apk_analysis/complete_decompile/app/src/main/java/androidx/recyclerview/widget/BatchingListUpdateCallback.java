package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a */
    public final ListUpdateCallback f6954a;

    /* renamed from: b */
    public int f6955b = 0;

    /* renamed from: c */
    public int f6956c = -1;

    /* renamed from: d */
    public int f6957d = -1;

    /* renamed from: e */
    public Object f6958e = null;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.f6954a = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i = this.f6955b;
        if (i == 0) {
            return;
        }
        ListUpdateCallback listUpdateCallback = this.f6954a;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    listUpdateCallback.onChanged(this.f6956c, this.f6957d, this.f6958e);
                }
            } else {
                listUpdateCallback.onRemoved(this.f6956c, this.f6957d);
            }
        } else {
            listUpdateCallback.onInserted(this.f6956c, this.f6957d);
        }
        this.f6958e = null;
        this.f6955b = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i, int i2, Object obj) {
        int i3;
        int i4;
        int i5;
        if (this.f6955b == 3 && i <= (i4 = this.f6957d + (i3 = this.f6956c)) && (i5 = i + i2) >= i3 && this.f6958e == obj) {
            this.f6956c = Math.min(i, i3);
            this.f6957d = Math.max(i4, i5) - this.f6956c;
            return;
        }
        dispatchLastEvent();
        this.f6956c = i;
        this.f6957d = i2;
        this.f6958e = obj;
        this.f6955b = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        int i3;
        if (this.f6955b == 1 && i >= (i3 = this.f6956c)) {
            int i4 = this.f6957d;
            if (i <= i3 + i4) {
                this.f6957d = i4 + i2;
                this.f6956c = Math.min(i, i3);
                return;
            }
        }
        dispatchLastEvent();
        this.f6956c = i;
        this.f6957d = i2;
        this.f6955b = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        dispatchLastEvent();
        this.f6954a.onMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        int i3;
        if (this.f6955b == 2 && (i3 = this.f6956c) >= i && i3 <= i + i2) {
            this.f6957d += i2;
            this.f6956c = i;
        } else {
            dispatchLastEvent();
            this.f6956c = i;
            this.f6957d = i2;
            this.f6955b = 2;
        }
    }
}
