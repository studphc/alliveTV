package p000;

import android.R;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController$AlertParams;
import androidx.appcompat.app.AlertController$RecycleListView;

/* renamed from: n7 */
/* loaded from: classes.dex */
public final class C1575n7 extends CursorAdapter {

    /* renamed from: a */
    public final int f23252a;

    /* renamed from: b */
    public final int f23253b;

    /* renamed from: c */
    public final /* synthetic */ AlertController$RecycleListView f23254c;

    /* renamed from: d */
    public final /* synthetic */ C1788s7 f23255d;

    /* renamed from: e */
    public final /* synthetic */ AlertController$AlertParams f23256e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1575n7(AlertController$AlertParams alertController$AlertParams, Context context, Cursor cursor, AlertController$RecycleListView alertController$RecycleListView, C1788s7 c1788s7) {
        super(context, cursor, false);
        this.f23256e = alertController$AlertParams;
        this.f23254c = alertController$RecycleListView;
        this.f23255d = c1788s7;
        Cursor cursor2 = getCursor();
        this.f23252a = cursor2.getColumnIndexOrThrow(alertController$AlertParams.mLabelColumn);
        this.f23253b = cursor2.getColumnIndexOrThrow(alertController$AlertParams.mIsCheckedColumn);
    }

    @Override // android.widget.CursorAdapter
    public final void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f23252a));
        int position = cursor.getPosition();
        int i = cursor.getInt(this.f23253b);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.f23254c.setItemChecked(position, z);
    }

    @Override // android.widget.CursorAdapter
    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f23256e.mInflater.inflate(this.f23255d.f26274L, viewGroup, false);
    }
}
