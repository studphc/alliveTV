package androidx.leanback.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class ItemAlignmentFacet {
    public static final float ITEM_ALIGN_OFFSET_PERCENT_DISABLED = -1.0f;

    /* renamed from: a */
    public ItemAlignmentDef[] f5861a = {new ItemAlignmentDef()};

    /* loaded from: classes.dex */
    public static class ItemAlignmentDef {

        /* renamed from: a */
        public int f5862a = -1;

        /* renamed from: b */
        public int f5863b = -1;

        /* renamed from: c */
        public int f5864c = 0;

        /* renamed from: d */
        public float f5865d = 50.0f;

        /* renamed from: e */
        public boolean f5866e = false;

        /* renamed from: f */
        public boolean f5867f;

        public final int getItemAlignmentFocusViewId() {
            int i = this.f5863b;
            if (i == -1) {
                return this.f5862a;
            }
            return i;
        }

        public final int getItemAlignmentOffset() {
            return this.f5864c;
        }

        public final float getItemAlignmentOffsetPercent() {
            return this.f5865d;
        }

        public final int getItemAlignmentViewId() {
            return this.f5862a;
        }

        public boolean isAlignedToTextViewBaseLine() {
            return this.f5867f;
        }

        public final boolean isItemAlignmentOffsetWithPadding() {
            return this.f5866e;
        }

        public final void setAlignedToTextViewBaseline(boolean z) {
            this.f5867f = z;
        }

        public final void setItemAlignmentFocusViewId(int i) {
            this.f5863b = i;
        }

        public final void setItemAlignmentOffset(int i) {
            this.f5864c = i;
        }

        public final void setItemAlignmentOffsetPercent(float f) {
            if ((f >= RecyclerView.f7068F0 && f <= 100.0f) || f == -1.0f) {
                this.f5865d = f;
                return;
            }
            throw new IllegalArgumentException();
        }

        public final void setItemAlignmentOffsetWithPadding(boolean z) {
            this.f5866e = z;
        }

        public final void setItemAlignmentViewId(int i) {
            this.f5862a = i;
        }
    }

    @NonNull
    public ItemAlignmentDef[] getAlignmentDefs() {
        return this.f5861a;
    }

    public boolean isMultiAlignment() {
        if (this.f5861a.length > 1) {
            return true;
        }
        return false;
    }

    public void setAlignmentDefs(@NonNull ItemAlignmentDef[] itemAlignmentDefArr) {
        if (itemAlignmentDefArr != null && itemAlignmentDefArr.length >= 1) {
            this.f5861a = itemAlignmentDefArr;
            return;
        }
        throw new IllegalArgumentException();
    }
}
