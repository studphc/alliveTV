package androidx.leanback.widget;

/* loaded from: classes.dex */
public class ListRow extends Row {

    /* renamed from: d */
    public final ObjectAdapter f5880d;

    /* renamed from: e */
    public CharSequence f5881e;

    public ListRow(HeaderItem headerItem, ObjectAdapter objectAdapter) {
        super(headerItem);
        this.f5880d = objectAdapter;
        if (objectAdapter == null) {
            throw new IllegalArgumentException("ObjectAdapter cannot be null");
        }
    }

    public final ObjectAdapter getAdapter() {
        return this.f5880d;
    }

    public CharSequence getContentDescription() {
        CharSequence charSequence = this.f5881e;
        if (charSequence != null) {
            return charSequence;
        }
        HeaderItem headerItem = getHeaderItem();
        if (headerItem != null) {
            CharSequence contentDescription = headerItem.getContentDescription();
            if (contentDescription != null) {
                return contentDescription;
            }
            return headerItem.getName();
        }
        return null;
    }

    public void setContentDescription(CharSequence charSequence) {
        this.f5881e = charSequence;
    }

    public ListRow(long j, HeaderItem headerItem, ObjectAdapter objectAdapter) {
        super(j, headerItem);
        this.f5880d = objectAdapter;
        if (objectAdapter == null) {
            throw new IllegalArgumentException("ObjectAdapter cannot be null");
        }
    }

    public ListRow(ObjectAdapter objectAdapter) {
        this.f5880d = objectAdapter;
        if (objectAdapter == null) {
            throw new IllegalArgumentException("ObjectAdapter cannot be null");
        }
    }
}
