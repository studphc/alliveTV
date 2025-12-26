package p000;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/* loaded from: classes.dex */
public final class kt2 implements lt2 {

    /* renamed from: c */
    public static final String[] f22196c = {"_data"};

    /* renamed from: d */
    public static final String[] f22197d = {"_data"};

    /* renamed from: a */
    public final /* synthetic */ int f22198a;

    /* renamed from: b */
    public final ContentResolver f22199b;

    public /* synthetic */ kt2(ContentResolver contentResolver, int i) {
        this.f22198a = i;
        this.f22199b = contentResolver;
    }

    @Override // p000.lt2
    /* renamed from: a */
    public final Cursor mo5789a(Uri uri) {
        switch (this.f22198a) {
            case 0:
                String lastPathSegment = uri.getLastPathSegment();
                return this.f22199b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f22196c, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            default:
                String lastPathSegment2 = uri.getLastPathSegment();
                return this.f22199b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f22197d, "kind = 1 AND video_id = ?", new String[]{lastPathSegment2}, null);
        }
    }
}
