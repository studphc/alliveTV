package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.XmlRes;
import androidx.core.util.ObjectsCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
import p000.AbstractC1726qj;
import p000.pc0;
import p000.qc0;

/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: e */
    public static final String[] f3525e = {"_display_name", "_size"};

    /* renamed from: f */
    public static final File f3526f = new File("/");

    /* renamed from: g */
    public static final HashMap f3527g = new HashMap();

    /* renamed from: a */
    public final Object f3528a;

    /* renamed from: b */
    public String f3529b;

    /* renamed from: c */
    public qc0 f3530c;

    /* renamed from: d */
    public final int f3531d;

    public FileProvider() {
        this(0);
    }

    /* renamed from: a */
    public static String m800a(String str) {
        if (str.length() > 0 && str.charAt(str.length() - 1) == '/') {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    /* renamed from: c */
    public static qc0 m801c(Context context, int i, String str) {
        qc0 qc0Var;
        HashMap hashMap = f3527g;
        synchronized (hashMap) {
            try {
                qc0Var = (qc0) hashMap.get(str);
                if (qc0Var == null) {
                    try {
                        try {
                            qc0Var = m802d(context, i, str);
                            hashMap.put(str, qc0Var);
                        } catch (IOException e) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                        }
                    } catch (XmlPullParserException e2) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return qc0Var;
    }

    /* renamed from: d */
    public static qc0 m802d(Context context, int i, String str) {
        qc0 qc0Var = new qc0(str);
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (resolveContentProvider != null) {
            if (resolveContentProvider.metaData == null && i != 0) {
                Bundle bundle = new Bundle(1);
                resolveContentProvider.metaData = bundle;
                bundle.putInt("android.support.FILE_PROVIDER_PATHS", i);
            }
            XmlResourceParser loadXmlMetaData = resolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
            if (loadXmlMetaData == null) {
                throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
            }
            while (true) {
                int next = loadXmlMetaData.next();
                if (next != 1) {
                    if (next == 2) {
                        String name = loadXmlMetaData.getName();
                        File file = null;
                        String attributeValue = loadXmlMetaData.getAttributeValue(null, AppMeasurementSdk.ConditionalUserProperty.NAME);
                        String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                        if ("root-path".equals(name)) {
                            file = f3526f;
                        } else if ("files-path".equals(name)) {
                            file = context.getFilesDir();
                        } else if ("cache-path".equals(name)) {
                            file = context.getCacheDir();
                        } else if ("external-path".equals(name)) {
                            file = Environment.getExternalStorageDirectory();
                        } else if ("external-files-path".equals(name)) {
                            File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, null);
                            if (externalFilesDirs.length > 0) {
                                file = externalFilesDirs[0];
                            }
                        } else if ("external-cache-path".equals(name)) {
                            File[] externalCacheDirs = ContextCompat.getExternalCacheDirs(context);
                            if (externalCacheDirs.length > 0) {
                                file = externalCacheDirs[0];
                            }
                        } else if ("external-media-path".equals(name)) {
                            File[] m6907a = pc0.m6907a(context);
                            if (m6907a.length > 0) {
                                file = m6907a[0];
                            }
                        }
                        if (file == null) {
                            continue;
                        } else {
                            String str2 = new String[]{attributeValue2}[0];
                            if (str2 != null) {
                                file = new File(file, str2);
                            }
                            if (!TextUtils.isEmpty(attributeValue)) {
                                try {
                                    qc0Var.f25513b.put(attributeValue, file.getCanonicalFile());
                                } catch (IOException e) {
                                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
                                }
                            } else {
                                throw new IllegalArgumentException("Name must not be empty");
                            }
                        }
                    }
                } else {
                    return qc0Var;
                }
            }
        } else {
            throw new IllegalArgumentException(AbstractC1726qj.m7038C("Couldn't find meta-data for provider with authority ", str));
        }
    }

    public static Uri getUriForFile(@NonNull Context context, @NonNull String str, @NonNull File file) {
        String substring;
        qc0 m801c = m801c(context, 0, str);
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry entry = null;
            for (Map.Entry entry2 : m801c.f25513b.entrySet()) {
                String path = ((File) entry2.getValue()).getPath();
                if (qc0.m7024a(canonicalPath, path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                    entry = entry2;
                }
            }
            if (entry != null) {
                String path2 = ((File) entry.getValue()).getPath();
                if (path2.endsWith("/")) {
                    substring = canonicalPath.substring(path2.length());
                } else {
                    substring = canonicalPath.substring(path2.length() + 1);
                }
                return new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(m801c.f25512a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
            }
            throw new IllegalArgumentException(AbstractC1726qj.m7038C("Failed to find configured root that contains ", canonicalPath));
        } catch (IOException unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
        }
    }

    @Override // android.content.ContentProvider
    @CallSuper
    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                String str = providerInfo.authority.split(";")[0];
                synchronized (this.f3528a) {
                    this.f3529b = str;
                }
                HashMap hashMap = f3527g;
                synchronized (hashMap) {
                    hashMap.remove(str);
                }
                return;
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }

    /* renamed from: b */
    public final qc0 m803b() {
        qc0 qc0Var;
        synchronized (this.f3528a) {
            try {
                ObjectsCompat.requireNonNull(this.f3529b, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
                if (this.f3530c == null) {
                    this.f3530c = m801c(getContext(), this.f3531d, this.f3529b);
                }
                qc0Var = this.f3530c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qc0Var;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return m803b().m7025b(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        File m7025b = m803b().m7025b(uri);
        int lastIndexOf = m7025b.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(m7025b.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
            return "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getTypeAnonymous(@NonNull Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri uri, @NonNull ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) {
        int i;
        File m7025b = m803b().m7025b(uri);
        if ("r".equals(str)) {
            i = 268435456;
        } else if (!"w".equals(str) && !"wt".equals(str)) {
            if ("wa".equals(str)) {
                i = 704643072;
            } else if ("rw".equals(str)) {
                i = 939524096;
            } else if ("rwt".equals(str)) {
                i = 1006632960;
            } else {
                throw new IllegalArgumentException(AbstractC1726qj.m7038C("Invalid mode: ", str));
            }
        } else {
            i = 738197504;
        }
        return ParcelFileDescriptor.open(m7025b, i);
    }

    @Override // android.content.ContentProvider
    @NonNull
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int i;
        String str3;
        File m7025b = m803b().m7025b(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f3525e;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str4 : strArr) {
            if ("_display_name".equals(str4)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                if (queryParameter == null) {
                    str3 = m7025b.getName();
                } else {
                    str3 = queryParameter;
                }
                objArr[i2] = str3;
            } else if ("_size".equals(str4)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(m7025b.length());
            }
            i2 = i;
        }
        String[] strArr4 = new String[i2];
        System.arraycopy(strArr3, 0, strArr4, 0, i2);
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @NonNull ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public FileProvider(@XmlRes int i) {
        this.f3528a = new Object();
        this.f3531d = i;
    }

    @NonNull
    @SuppressLint({"StreamFiles"})
    public static Uri getUriForFile(@NonNull Context context, @NonNull String str, @NonNull File file, @NonNull String str2) {
        return getUriForFile(context, str, file).buildUpon().appendQueryParameter("displayName", str2).build();
    }
}
