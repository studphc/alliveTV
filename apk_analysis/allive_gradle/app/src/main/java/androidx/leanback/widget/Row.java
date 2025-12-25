package androidx.leanback.widget;

/* loaded from: classes.dex */
public class Row {

    /* renamed from: b */
    public HeaderItem f6094b;

    /* renamed from: a */
    public int f6093a = 1;

    /* renamed from: c */
    public long f6095c = -1;

    public Row(long j, HeaderItem headerItem) {
        setId(j);
        setHeaderItem(headerItem);
    }

    public final HeaderItem getHeaderItem() {
        return this.f6094b;
    }

    public final long getId() {
        if ((this.f6093a & 1) == 1) {
            HeaderItem headerItem = getHeaderItem();
            if (headerItem != null) {
                return headerItem.getId();
            }
            return -1L;
        }
        return this.f6095c;
    }

    public boolean isRenderedAsRowView() {
        return true;
    }

    public final void setHeaderItem(HeaderItem headerItem) {
        this.f6094b = headerItem;
    }

    public final void setId(long j) {
        this.f6095c = j;
        this.f6093a &= -2;
    }

    public Row(HeaderItem headerItem) {
        setHeaderItem(headerItem);
    }

    public Row() {
    }
}
