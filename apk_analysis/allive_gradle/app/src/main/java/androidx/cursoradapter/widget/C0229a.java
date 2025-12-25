package androidx.cursoradapter.widget;

import android.database.DataSetObserver;

/* renamed from: androidx.cursoradapter.widget.a */
/* loaded from: classes.dex */
public final class C0229a extends DataSetObserver {

    /* renamed from: a */
    public final /* synthetic */ CursorAdapter f4095a;

    public C0229a(CursorAdapter cursorAdapter) {
        this.f4095a = cursorAdapter;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        CursorAdapter cursorAdapter = this.f4095a;
        cursorAdapter.mDataValid = true;
        cursorAdapter.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        CursorAdapter cursorAdapter = this.f4095a;
        cursorAdapter.mDataValid = false;
        cursorAdapter.notifyDataSetInvalidated();
    }
}
