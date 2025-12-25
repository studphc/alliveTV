package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import p000.C1224g9;

/* loaded from: classes.dex */
public final class AppCompatDelegateImpl$PanelFeatureState {

    /* renamed from: a */
    public int f603a;

    /* renamed from: b */
    public int f604b;

    /* renamed from: c */
    public int f605c;

    /* renamed from: d */
    public int f606d;

    /* renamed from: e */
    public C1224g9 f607e;

    /* renamed from: f */
    public View f608f;

    /* renamed from: g */
    public View f609g;

    /* renamed from: h */
    public MenuBuilder f610h;

    /* renamed from: i */
    public ListMenuPresenter f611i;

    /* renamed from: j */
    public ContextThemeWrapper f612j;

    /* renamed from: k */
    public boolean f613k;

    /* renamed from: l */
    public boolean f614l;

    /* renamed from: m */
    public boolean f615m;

    /* renamed from: n */
    public boolean f616n;

    /* renamed from: o */
    public boolean f617o;

    /* renamed from: p */
    public Bundle f618p;
    public boolean qwertyMode;

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a */
        public int f619a;

        /* renamed from: b */
        public boolean f620b;

        /* renamed from: c */
        public Bundle f621c;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState] */
        /* renamed from: a */
        public static SavedState m164a(Parcel parcel, ClassLoader classLoader) {
            ?? obj = new Object();
            obj.f619a = parcel.readInt();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            obj.f620b = z;
            if (z) {
                obj.f621c = parcel.readBundle(classLoader);
            }
            return obj;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f619a);
            parcel.writeInt(this.f620b ? 1 : 0);
            if (this.f620b) {
                parcel.writeBundle(this.f621c);
            }
        }
    }

    public void clearMenuPresenters() {
        MenuBuilder menuBuilder = this.f610h;
        if (menuBuilder != null) {
            menuBuilder.removeMenuPresenter(this.f611i);
        }
        this.f611i = null;
    }

    public boolean hasPanelItems() {
        if (this.f608f == null) {
            return false;
        }
        if (this.f609g == null && this.f611i.getAdapter().getCount() <= 0) {
            return false;
        }
        return true;
    }
}
