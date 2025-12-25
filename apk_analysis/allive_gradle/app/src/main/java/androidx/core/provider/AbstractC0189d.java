package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.http.HttpStatusCodesKt;
import p000.AbstractC1726qj;
import p000.C0556bg;
import p000.vs0;

/* renamed from: androidx.core.provider.d */
/* loaded from: classes.dex */
public abstract class AbstractC0189d {

    /* renamed from: a */
    public static final C0556bg f3746a = new C0556bg(11);

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x007a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0140  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static FontsContractCompat.FontFamilyResult m882a(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) {
        vs0 vs0Var;
        Cursor cursor;
        int i;
        int i2;
        Uri withAppendedId;
        int i3;
        boolean z;
        ProviderInfo m883b = m883b(context.getPackageManager(), fontRequest, context.getResources());
        Cursor cursor2 = null;
        if (m883b == null) {
            return new FontsContractCompat.FontFamilyResult(1, null);
        }
        String str = m883b.authority;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(str).build();
        Uri build2 = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(str).appendPath("file").build();
        if (Build.VERSION.SDK_INT < 24) {
            vs0Var = new vs0(context, build, 0);
        } else {
            vs0Var = new vs0(context, build, 1);
        }
        try {
            String[] strArr = {"_id", FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, FontsContractCompat.Columns.RESULT_CODE};
            String[] strArr2 = {fontRequest.getQuery()};
            switch (vs0Var.f27941a) {
                case 0:
                    cursor = null;
                    ContentProviderClient contentProviderClient = vs0Var.f27942b;
                    if (contentProviderClient != null) {
                        try {
                            cursor = contentProviderClient.query(build, strArr, "query = ?", strArr2, null, cancellationSignal);
                        } catch (RemoteException e) {
                            Log.w("FontsProvider", "Unable to query the content provider", e);
                        }
                    }
                    cursor2 = cursor;
                    if (cursor2 != null && cursor2.getCount() > 0) {
                        int columnIndex = cursor2.getColumnIndex(FontsContractCompat.Columns.RESULT_CODE);
                        arrayList = new ArrayList();
                        int columnIndex2 = cursor2.getColumnIndex("_id");
                        int columnIndex3 = cursor2.getColumnIndex(FontsContractCompat.Columns.FILE_ID);
                        int columnIndex4 = cursor2.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);
                        int columnIndex5 = cursor2.getColumnIndex(FontsContractCompat.Columns.WEIGHT);
                        int columnIndex6 = cursor2.getColumnIndex(FontsContractCompat.Columns.ITALIC);
                        while (cursor2.moveToNext()) {
                            if (columnIndex != -1) {
                                i = cursor2.getInt(columnIndex);
                            } else {
                                i = 0;
                            }
                            if (columnIndex4 != -1) {
                                i2 = cursor2.getInt(columnIndex4);
                            } else {
                                i2 = 0;
                            }
                            if (columnIndex3 == -1) {
                                withAppendedId = ContentUris.withAppendedId(build, cursor2.getLong(columnIndex2));
                            } else {
                                withAppendedId = ContentUris.withAppendedId(build2, cursor2.getLong(columnIndex3));
                            }
                            Uri uri = withAppendedId;
                            if (columnIndex5 != -1) {
                                i3 = cursor2.getInt(columnIndex5);
                            } else {
                                i3 = HttpStatusCodesKt.HTTP_BAD_REQUEST;
                            }
                            int i4 = i3;
                            if (columnIndex6 != -1 && cursor2.getInt(columnIndex6) == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            arrayList.add(new FontsContractCompat.FontInfo(uri, i2, i4, z, i));
                        }
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    vs0Var.m7931a();
                    return new FontsContractCompat.FontFamilyResult(0, (FontsContractCompat.FontInfo[]) arrayList.toArray(new FontsContractCompat.FontInfo[0]));
                default:
                    cursor = null;
                    ContentProviderClient contentProviderClient2 = vs0Var.f27942b;
                    if (contentProviderClient2 != null) {
                        try {
                            cursor = contentProviderClient2.query(build, strArr, "query = ?", strArr2, null, cancellationSignal);
                        } catch (RemoteException e2) {
                            Log.w("FontsProvider", "Unable to query the content provider", e2);
                        }
                    }
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        int columnIndex7 = cursor2.getColumnIndex(FontsContractCompat.Columns.RESULT_CODE);
                        arrayList = new ArrayList();
                        int columnIndex22 = cursor2.getColumnIndex("_id");
                        int columnIndex32 = cursor2.getColumnIndex(FontsContractCompat.Columns.FILE_ID);
                        int columnIndex42 = cursor2.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);
                        int columnIndex52 = cursor2.getColumnIndex(FontsContractCompat.Columns.WEIGHT);
                        int columnIndex62 = cursor2.getColumnIndex(FontsContractCompat.Columns.ITALIC);
                        while (cursor2.moveToNext()) {
                        }
                        break;
                    }
                    if (cursor2 != null) {
                    }
                    vs0Var.m7931a();
                    return new FontsContractCompat.FontFamilyResult(0, (FontsContractCompat.FontInfo[]) arrayList.toArray(new FontsContractCompat.FontInfo[0]));
            }
        } catch (Throwable th) {
            if (cursor2 != null) {
                cursor2.close();
            }
            vs0Var.m7931a();
            throw th;
        }
    }

    /* renamed from: b */
    public static ProviderInfo m883b(PackageManager packageManager, FontRequest fontRequest, Resources resources) {
        List<List<byte[]>> readCerts;
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider != null) {
            if (resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
                Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArr) {
                    arrayList.add(signature.toByteArray());
                }
                C0556bg c0556bg = f3746a;
                Collections.sort(arrayList, c0556bg);
                if (fontRequest.getCertificates() != null) {
                    readCerts = fontRequest.getCertificates();
                } else {
                    readCerts = FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
                }
                for (int i = 0; i < readCerts.size(); i++) {
                    ArrayList arrayList2 = new ArrayList(readCerts.get(i));
                    Collections.sort(arrayList2, c0556bg);
                    if (arrayList.size() == arrayList2.size()) {
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            if (!Arrays.equals((byte[]) arrayList.get(i2), (byte[]) arrayList2.get(i2))) {
                                break;
                            }
                        }
                        return resolveContentProvider;
                    }
                }
                return null;
            }
            StringBuilder m7065u = AbstractC1726qj.m7065u("Found content provider ", providerAuthority, ", but package was not ");
            m7065u.append(fontRequest.getProviderPackage());
            throw new PackageManager.NameNotFoundException(m7065u.toString());
        }
        throw new PackageManager.NameNotFoundException(AbstractC1726qj.m7038C("No package found for authority: ", providerAuthority));
    }
}
