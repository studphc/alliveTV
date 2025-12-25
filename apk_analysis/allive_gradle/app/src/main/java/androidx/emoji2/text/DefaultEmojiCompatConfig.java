package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class DefaultEmojiCompatConfig {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class DefaultEmojiCompatConfigFactory {

        /* renamed from: a */
        public final DefaultEmojiCompatConfigHelper f4179a;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public DefaultEmojiCompatConfigFactory(@Nullable DefaultEmojiCompatConfigHelper defaultEmojiCompatConfigHelper) {
            if (defaultEmojiCompatConfigHelper == null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    defaultEmojiCompatConfigHelper = new DefaultEmojiCompatConfigHelper_API28();
                } else {
                    defaultEmojiCompatConfigHelper = new DefaultEmojiCompatConfigHelper_API19();
                }
            }
            this.f4179a = defaultEmojiCompatConfigHelper;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public EmojiCompat.Config create(@NonNull Context context) {
            ProviderInfo providerInfo;
            FontRequest fontRequest;
            ApplicationInfo applicationInfo;
            PackageManager packageManager = context.getPackageManager();
            Preconditions.checkNotNull(packageManager, "Package manager required to locate emoji font provider");
            Intent intent = new Intent("androidx.content.action.LOAD_EMOJI_FONT");
            DefaultEmojiCompatConfigHelper defaultEmojiCompatConfigHelper = this.f4179a;
            Iterator<ResolveInfo> it = defaultEmojiCompatConfigHelper.queryIntentContentProviders(packageManager, intent, 0).iterator();
            while (true) {
                if (it.hasNext()) {
                    providerInfo = defaultEmojiCompatConfigHelper.getProviderInfo(it.next());
                    if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                        break;
                    }
                } else {
                    providerInfo = null;
                    break;
                }
            }
            if (providerInfo != null) {
                try {
                    String str = providerInfo.authority;
                    String str2 = providerInfo.packageName;
                    Signature[] signingSignatures = defaultEmojiCompatConfigHelper.getSigningSignatures(packageManager, str2);
                    ArrayList arrayList = new ArrayList();
                    for (Signature signature : signingSignatures) {
                        arrayList.add(signature.toByteArray());
                    }
                    fontRequest = new FontRequest(str, str2, "emojicompat-emoji-font", (List<List<byte[]>>) Collections.singletonList(arrayList));
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("emoji2.text.DefaultEmojiConfig", e);
                }
                if (fontRequest != null) {
                    return null;
                }
                return new FontRequestEmojiCompatConfig(context, fontRequest);
            }
            fontRequest = null;
            if (fontRequest != null) {
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class DefaultEmojiCompatConfigHelper {
        @Nullable
        public ProviderInfo getProviderInfo(@NonNull ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        @NonNull
        public Signature[] getSigningSignatures(@NonNull PackageManager packageManager, @NonNull String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        @NonNull
        public List<ResolveInfo> queryIntentContentProviders(@NonNull PackageManager packageManager, @NonNull Intent intent, int i) {
            return Collections.emptyList();
        }
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        @Nullable
        public ProviderInfo getProviderInfo(@NonNull ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        @NonNull
        public List<ResolveInfo> queryIntentContentProviders(@NonNull PackageManager packageManager, @NonNull Intent intent, int i) {
            return packageManager.queryIntentContentProviders(intent, i);
        }
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        @NonNull
        public Signature[] getSigningSignatures(@NonNull PackageManager packageManager, @NonNull String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    @Nullable
    public static FontRequestEmojiCompatConfig create(@NonNull Context context) {
        return (FontRequestEmojiCompatConfig) new DefaultEmojiCompatConfigFactory(null).create(context);
    }
}
