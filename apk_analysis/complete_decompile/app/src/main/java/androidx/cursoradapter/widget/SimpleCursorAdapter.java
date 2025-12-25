package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public class SimpleCursorAdapter extends ResourceCursorAdapter {

    /* renamed from: d */
    public int f4091d;

    /* renamed from: e */
    public CursorToStringConverter f4092e;

    /* renamed from: f */
    public ViewBinder f4093f;

    /* renamed from: g */
    public String[] f4094g;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int[] mFrom;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int[] mTo;

    /* loaded from: classes.dex */
    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    /* loaded from: classes.dex */
    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i);
    }

    @Deprecated
    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i, cursor);
        this.f4091d = -1;
        this.mTo = iArr;
        this.f4094g = strArr;
        m1028b(cursor, strArr);
    }

    /* renamed from: b */
    public final void m1028b(Cursor cursor, String[] strArr) {
        if (cursor != null) {
            int length = strArr.length;
            int[] iArr = this.mFrom;
            if (iArr == null || iArr.length != length) {
                this.mFrom = new int[length];
            }
            for (int i = 0; i < length; i++) {
                this.mFrom[i] = cursor.getColumnIndexOrThrow(strArr[i]);
            }
            return;
        }
        this.mFrom = null;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        boolean z;
        ViewBinder viewBinder = this.f4093f;
        int[] iArr = this.mTo;
        int length = iArr.length;
        int[] iArr2 = this.mFrom;
        for (int i = 0; i < length; i++) {
            View findViewById = view.findViewById(iArr[i]);
            if (findViewById != null) {
                if (viewBinder != null) {
                    z = viewBinder.setViewValue(findViewById, cursor, iArr2[i]);
                } else {
                    z = false;
                }
                if (z) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (findViewById instanceof TextView) {
                        setViewText((TextView) findViewById, string);
                    } else if (findViewById instanceof ImageView) {
                        setViewImage((ImageView) findViewById, string);
                    } else {
                        throw new IllegalStateException(findViewById.getClass().getName().concat(" is not a  view that can be bounds by this SimpleCursorAdapter"));
                    }
                }
            }
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String[] strArr, int[] iArr) {
        this.f4094g = strArr;
        this.mTo = iArr;
        m1028b(cursor, strArr);
        super.changeCursor(cursor);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, p000.InterfaceC2035yw
    public CharSequence convertToString(Cursor cursor) {
        CursorToStringConverter cursorToStringConverter = this.f4092e;
        if (cursorToStringConverter != null) {
            return cursorToStringConverter.convertToString(cursor);
        }
        int i = this.f4091d;
        if (i > -1) {
            return cursor.getString(i);
        }
        return super.convertToString(cursor);
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.f4092e;
    }

    public int getStringConversionColumn() {
        return this.f4091d;
    }

    public ViewBinder getViewBinder() {
        return this.f4093f;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        this.f4092e = cursorToStringConverter;
    }

    public void setStringConversionColumn(int i) {
        this.f4091d = i;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.f4093f = viewBinder;
    }

    public void setViewImage(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void setViewText(TextView textView, String str) {
        textView.setText(str);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        m1028b(cursor, this.f4094g);
        return super.swapCursor(cursor);
    }

    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        this.f4091d = -1;
        this.mTo = iArr;
        this.f4094g = strArr;
        m1028b(cursor, strArr);
    }
}
