package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* renamed from: a */
    public int f4088a;

    /* renamed from: b */
    public int f4089b;

    /* renamed from: c */
    public final LayoutInflater f4090c;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i, Cursor cursor) {
        super(context, cursor);
        this.f4089b = i;
        this.f4088a = i;
        this.f4090c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f4090c.inflate(this.f4089b, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f4090c.inflate(this.f4088a, viewGroup, false);
    }

    public void setDropDownViewResource(int i) {
        this.f4089b = i;
    }

    public void setViewResource(int i) {
        this.f4088a = i;
    }

    @Deprecated
    public ResourceCursorAdapter(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f4089b = i;
        this.f4088a = i;
        this.f4090c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, int i2) {
        super(context, cursor, i2);
        this.f4089b = i;
        this.f4088a = i;
        this.f4090c = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
