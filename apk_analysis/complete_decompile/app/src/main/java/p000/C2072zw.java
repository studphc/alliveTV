package p000;

import android.database.Cursor;
import android.widget.Filter;
import androidx.cursoradapter.widget.CursorAdapter;

/* renamed from: zw */
/* loaded from: classes.dex */
public final class C2072zw extends Filter {

    /* renamed from: a */
    public CursorAdapter f29527a;

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        return this.f29527a.convertToString((Cursor) obj);
    }

    @Override // android.widget.Filter
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.f29527a.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        CursorAdapter cursorAdapter = this.f29527a;
        Cursor cursor = cursorAdapter.getCursor();
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            cursorAdapter.changeCursor((Cursor) obj);
        }
    }
}
