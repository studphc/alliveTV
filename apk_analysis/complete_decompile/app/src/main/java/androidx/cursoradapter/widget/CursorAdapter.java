package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.annotation.RestrictTo;
import p000.C1998xw;
import p000.C2072zw;
import p000.InterfaceC2035yw;
import p000.ye0;

/* loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, InterfaceC2035yw {

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mAutoRequery;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected C1998xw mChangeObserver;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Context mContext;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Cursor mCursor;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected C2072zw mCursorFilter;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected DataSetObserver mDataSetObserver;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mDataValid;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected FilterQueryProvider mFilterQueryProvider;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int mRowIDColumn;

    @Deprecated
    public CursorAdapter(Context context, Cursor cursor) {
        m1027a(context, cursor, 1);
    }

    /* renamed from: a */
    public final void m1027a(Context context, Cursor cursor, int i) {
        int i2;
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.mAutoRequery = true;
        } else {
            this.mAutoRequery = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.mCursor = cursor;
        this.mDataValid = z;
        this.mContext = context;
        if (z) {
            i2 = cursor.getColumnIndexOrThrow("_id");
        } else {
            i2 = -1;
        }
        this.mRowIDColumn = i2;
        if ((i & 2) == 2) {
            this.mChangeObserver = new C1998xw(this);
            this.mDataSetObserver = new C0229a(this);
        } else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (z) {
            C1998xw c1998xw = this.mChangeObserver;
            if (c1998xw != null) {
                cursor.registerContentObserver(c1998xw);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    @Override // p000.InterfaceC2035yw
    public void changeCursor(Cursor cursor) {
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    @Override // p000.InterfaceC2035yw
    public CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return "";
        }
        return cursor.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (this.mDataValid && (cursor = this.mCursor) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // p000.InterfaceC2035yw
    public Cursor getCursor() {
        return this.mCursor;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.mDataValid) {
            this.mCursor.moveToPosition(i);
            if (view == null) {
                view = newDropDownView(this.mContext, this.mCursor, viewGroup);
            }
            bindView(view, this.mContext, this.mCursor);
            return view;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.Filter, zw] */
    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mCursorFilter == null) {
            ?? filter = new Filter();
            filter.f29527a = this;
            this.mCursorFilter = filter;
        }
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (this.mDataValid && (cursor = this.mCursor) != null) {
            cursor.moveToPosition(i);
            return this.mCursor;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null || !cursor.moveToPosition(i)) {
            return 0L;
        }
        return this.mCursor.getLong(this.mRowIDColumn);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.mDataValid) {
            if (this.mCursor.moveToPosition(i)) {
                if (view == null) {
                    view = newView(this.mContext, this.mCursor, viewGroup);
                }
                bindView(view, this.mContext, this.mCursor);
                return view;
            }
            throw new IllegalStateException(ye0.m8291k(i, "couldn't move cursor to position "));
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Deprecated
    public void init(Context context, Cursor cursor, boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        m1027a(context, cursor, i);
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public void onContentChanged() {
        Cursor cursor;
        if (this.mAutoRequery && (cursor = this.mCursor) != null && !cursor.isClosed()) {
            this.mDataValid = this.mCursor.requery();
        }
    }

    @Override // p000.InterfaceC2035yw
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.mFilterQueryProvider;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.mFilterQueryProvider = filterQueryProvider;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C1998xw c1998xw = this.mChangeObserver;
            if (c1998xw != null) {
                cursor2.unregisterContentObserver(c1998xw);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mCursor = cursor;
        if (cursor != null) {
            C1998xw c1998xw2 = this.mChangeObserver;
            if (c1998xw2 != null) {
                cursor.registerContentObserver(c1998xw2);
            }
            DataSetObserver dataSetObserver2 = this.mDataSetObserver;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            notifyDataSetChanged();
        } else {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        m1027a(context, cursor, z ? 1 : 2);
    }

    public CursorAdapter(Context context, Cursor cursor, int i) {
        m1027a(context, cursor, i);
    }
}
