package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "WebImageCreator")
/* loaded from: classes.dex */
public final class WebImage extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<WebImage> CREATOR = new zah();

    /* renamed from: a */
    public final int f13354a;

    /* renamed from: b */
    public final Uri f13355b;

    /* renamed from: c */
    public final int f13356c;

    /* renamed from: d */
    public final int f13357d;

    public WebImage(int i, Uri uri, int i2, int i3) {
        this.f13354a = i;
        this.f13355b = uri;
        this.f13356c = i2;
        this.f13357d = i3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (Objects.equal(this.f13355b, webImage.f13355b) && this.f13356c == webImage.f13356c && this.f13357d == webImage.f13357d) {
                return true;
            }
        }
        return false;
    }

    public int getHeight() {
        return this.f13357d;
    }

    @NonNull
    public Uri getUrl() {
        return this.f13355b;
    }

    public int getWidth() {
        return this.f13356c;
    }

    public int hashCode() {
        return Objects.hashCode(this.f13355b, Integer.valueOf(this.f13356c), Integer.valueOf(this.f13357d));
    }

    @NonNull
    @KeepForSdk
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ImagesContract.URL, this.f13355b.toString());
            jSONObject.put("width", this.f13356c);
            jSONObject.put("height", this.f13357d);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        Locale locale = Locale.US;
        return "Image " + this.f13356c + "x" + this.f13357d + " " + this.f13355b.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13354a);
        SafeParcelWriter.writeParcelable(parcel, 2, getUrl(), i, false);
        SafeParcelWriter.writeInt(parcel, 3, getWidth());
        SafeParcelWriter.writeInt(parcel, 4, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public WebImage(@NonNull Uri uri) {
        this(uri, 0, 0);
    }

    public WebImage(@NonNull Uri uri, int i, int i2) {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WebImage(@NonNull JSONObject jSONObject) {
        this(r0, jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
        Uri uri = Uri.EMPTY;
        if (jSONObject.has(ImagesContract.URL)) {
            try {
                uri = Uri.parse(jSONObject.getString(ImagesContract.URL));
            } catch (JSONException unused) {
            }
        }
    }
}
