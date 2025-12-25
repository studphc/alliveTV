package androidx.emoji2.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p000.ge3;
import p000.i03;
import p000.i80;

@AnyThread
/* loaded from: classes.dex */
public class EmojiCompat {
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";
    public static final int EMOJI_FALLBACK = 2;
    public static final int EMOJI_SUPPORTED = 1;
    public static final int EMOJI_UNSUPPORTED = 0;
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;

    /* renamed from: o */
    public static final Object f4180o = new Object();

    /* renamed from: p */
    public static final Object f4181p = new Object();

    /* renamed from: q */
    public static volatile EmojiCompat f4182q;

    /* renamed from: r */
    public static volatile boolean f4183r;

    /* renamed from: a */
    public final ReentrantReadWriteLock f4184a;

    /* renamed from: b */
    public final ArraySet f4185b;

    /* renamed from: c */
    public volatile int f4186c;

    /* renamed from: d */
    public final Handler f4187d;

    /* renamed from: e */
    public final C0236c f4188e;

    /* renamed from: f */
    public final MetadataRepoLoader f4189f;

    /* renamed from: g */
    public final SpanFactory f4190g;

    /* renamed from: h */
    public final boolean f4191h;

    /* renamed from: i */
    public final boolean f4192i;

    /* renamed from: j */
    public final int[] f4193j;

    /* renamed from: k */
    public final boolean f4194k;

    /* renamed from: l */
    public final int f4195l;

    /* renamed from: m */
    public final int f4196m;

    /* renamed from: n */
    public final GlyphChecker f4197n;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface CodepointSequenceMatchResult {
    }

    /* loaded from: classes.dex */
    public static abstract class Config {

        /* renamed from: a */
        public final MetadataRepoLoader f4198a;

        /* renamed from: b */
        public SpanFactory f4199b;

        /* renamed from: c */
        public boolean f4200c;

        /* renamed from: d */
        public boolean f4201d;

        /* renamed from: e */
        public int[] f4202e;

        /* renamed from: f */
        public ArraySet f4203f;

        /* renamed from: g */
        public boolean f4204g;

        /* renamed from: h */
        public int f4205h = -16711936;

        /* renamed from: i */
        public int f4206i = 0;

        /* renamed from: j */
        public GlyphChecker f4207j = new C0234a();

        public Config(@NonNull MetadataRepoLoader metadataRepoLoader) {
            Preconditions.checkNotNull(metadataRepoLoader, "metadataLoader cannot be null.");
            this.f4198a = metadataRepoLoader;
        }

        @NonNull
        public final MetadataRepoLoader getMetadataRepoLoader() {
            return this.f4198a;
        }

        @NonNull
        public Config registerInitCallback(@NonNull InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            if (this.f4203f == null) {
                this.f4203f = new ArraySet();
            }
            this.f4203f.add(initCallback);
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorColor(@ColorInt int i) {
            this.f4205h = i;
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorEnabled(boolean z) {
            this.f4204g = z;
            return this;
        }

        @NonNull
        public Config setGlyphChecker(@NonNull GlyphChecker glyphChecker) {
            Preconditions.checkNotNull(glyphChecker, "GlyphChecker cannot be null");
            this.f4207j = glyphChecker;
            return this;
        }

        @NonNull
        public Config setMetadataLoadStrategy(int i) {
            this.f4206i = i;
            return this;
        }

        @NonNull
        public Config setReplaceAll(boolean z) {
            this.f4200c = z;
            return this;
        }

        @NonNull
        public Config setSpanFactory(@NonNull SpanFactory spanFactory) {
            this.f4199b = spanFactory;
            return this;
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean z) {
            return setUseEmojiAsDefaultStyle(z, null);
        }

        @NonNull
        public Config unregisterInitCallback(@NonNull InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            ArraySet arraySet = this.f4203f;
            if (arraySet != null) {
                arraySet.remove(initCallback);
            }
            return this;
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean z, @Nullable List<Integer> list) {
            this.f4201d = z;
            if (z && list != null) {
                this.f4202e = new int[list.size()];
                Iterator<Integer> it = list.iterator();
                int i = 0;
                while (it.hasNext()) {
                    this.f4202e[i] = it.next().intValue();
                    i++;
                }
                Arrays.sort(this.f4202e);
            } else {
                this.f4202e = null;
            }
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class DefaultSpanFactory implements SpanFactory {
        @Override // androidx.emoji2.text.EmojiCompat.SpanFactory
        @NonNull
        @RequiresApi(19)
        public EmojiSpan createSpan(@NonNull TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            return new TypefaceEmojiSpan(typefaceEmojiRasterizer);
        }
    }

    /* loaded from: classes.dex */
    public interface GlyphChecker {
        boolean hasGlyph(@NonNull CharSequence charSequence, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3);
    }

    /* loaded from: classes.dex */
    public static abstract class InitCallback {
        public void onFailed(@Nullable Throwable th) {
        }

        public void onInitialized() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface LoadStrategy {
    }

    /* loaded from: classes.dex */
    public interface MetadataRepoLoader {
        void load(@NonNull MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    /* loaded from: classes.dex */
    public static abstract class MetadataRepoLoaderCallback {
        public abstract void onFailed(@Nullable Throwable th);

        public abstract void onLoaded(@NonNull MetadataRepo metadataRepo);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface ReplaceStrategy {
    }

    /* loaded from: classes.dex */
    public interface SpanFactory {
        @NonNull
        @RequiresApi(19)
        EmojiSpan createSpan(@NonNull TypefaceEmojiRasterizer typefaceEmojiRasterizer);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [ge3, androidx.emoji2.text.c] */
    public EmojiCompat(Config config) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f4184a = reentrantReadWriteLock;
        this.f4186c = 3;
        this.f4191h = config.f4200c;
        this.f4192i = config.f4201d;
        this.f4193j = config.f4202e;
        this.f4194k = config.f4204g;
        this.f4195l = config.f4205h;
        MetadataRepoLoader metadataRepoLoader = config.f4198a;
        this.f4189f = metadataRepoLoader;
        int i = config.f4206i;
        this.f4196m = i;
        this.f4197n = config.f4207j;
        this.f4187d = new Handler(Looper.getMainLooper());
        ArraySet arraySet = new ArraySet();
        this.f4185b = arraySet;
        SpanFactory spanFactory = config.f4199b;
        this.f4190g = spanFactory == null ? new DefaultSpanFactory() : spanFactory;
        ArraySet arraySet2 = config.f4203f;
        if (arraySet2 != null && !arraySet2.isEmpty()) {
            arraySet.addAll((Collection) config.f4203f);
        }
        ?? ge3Var = new ge3(this);
        this.f4188e = ge3Var;
        reentrantReadWriteLock.writeLock().lock();
        if (i == 0) {
            try {
                this.f4186c = 0;
            } catch (Throwable th) {
                this.f4184a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (getLoadState() == 0) {
            try {
                metadataRepoLoader.load(new C0235b(ge3Var));
            } catch (Throwable th2) {
                m1060b(th2);
            }
        }
    }

    @NonNull
    public static EmojiCompat get() {
        EmojiCompat emojiCompat;
        boolean z;
        synchronized (f4180o) {
            emojiCompat = f4182q;
            if (emojiCompat != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return emojiCompat;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0049, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0086, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0079, code lost:
    
        if (r11 != false) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean handleDeleteSurroundingText(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, boolean z) {
        int min;
        if (editable == null || inputConnection == null || i < 0 || i2 < 0) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart == -1 || selectionEnd == -1 || selectionStart != selectionEnd) {
            return false;
        }
        if (z) {
            int max = Math.max(i, 0);
            int length = editable.length();
            if (selectionStart >= 0 && length >= selectionStart && max >= 0) {
                loop0: while (true) {
                    boolean z2 = false;
                    while (true) {
                        if (max == 0) {
                            break loop0;
                        }
                        selectionStart--;
                        if (selectionStart < 0) {
                            if (!z2) {
                                selectionStart = 0;
                            }
                        } else {
                            char charAt = editable.charAt(selectionStart);
                            if (z2) {
                                break;
                            }
                            if (Character.isSurrogate(charAt)) {
                                if (Character.isHighSurrogate(charAt)) {
                                    break loop0;
                                }
                                z2 = true;
                            } else {
                                max--;
                            }
                        }
                    }
                    max--;
                }
            }
            selectionStart = -1;
            int max2 = Math.max(i2, 0);
            min = editable.length();
            if (selectionEnd >= 0 && min >= selectionEnd && max2 >= 0) {
                loop2: while (true) {
                    boolean z3 = false;
                    while (true) {
                        if (max2 == 0) {
                            min = selectionEnd;
                            break loop2;
                        }
                        if (selectionEnd < min) {
                            char charAt2 = editable.charAt(selectionEnd);
                            if (z3) {
                                break;
                            }
                            if (!Character.isSurrogate(charAt2)) {
                                max2--;
                                selectionEnd++;
                            } else {
                                if (Character.isLowSurrogate(charAt2)) {
                                    break loop2;
                                }
                                selectionEnd++;
                                z3 = true;
                            }
                        }
                    }
                    max2--;
                    selectionEnd++;
                }
            }
            min = -1;
            if (selectionStart == -1 || min == -1) {
                return false;
            }
        } else {
            selectionStart = Math.max(selectionStart - i, 0);
            min = Math.min(selectionEnd + i2, editable.length());
        }
        EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, min, EmojiSpan.class);
        if (emojiSpanArr == null || emojiSpanArr.length <= 0) {
            return false;
        }
        for (EmojiSpan emojiSpan : emojiSpanArr) {
            int spanStart = editable.getSpanStart(emojiSpan);
            int spanEnd = editable.getSpanEnd(emojiSpan);
            selectionStart = Math.min(spanStart, selectionStart);
            min = Math.max(spanEnd, min);
        }
        int max3 = Math.max(selectionStart, 0);
        int min2 = Math.min(min, editable.length());
        inputConnection.beginBatchEdit();
        editable.delete(max3, min2);
        inputConnection.endBatchEdit();
        return true;
    }

    public static boolean handleOnKeyDown(@NonNull Editable editable, int i, @NonNull KeyEvent keyEvent) {
        boolean m1082a;
        if (i != 67) {
            if (i != 112) {
                m1082a = false;
            } else {
                m1082a = C0242i.m1082a(editable, keyEvent, true);
            }
        } else {
            m1082a = C0242i.m1082a(editable, keyEvent, false);
        }
        if (!m1082a) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    @Nullable
    public static EmojiCompat init(@NonNull Context context) {
        return init(context, null);
    }

    public static boolean isConfigured() {
        if (f4182q != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public static EmojiCompat reset(@NonNull Config config) {
        EmojiCompat emojiCompat;
        synchronized (f4180o) {
            emojiCompat = new EmojiCompat(config);
            f4182q = emojiCompat;
        }
        return emojiCompat;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void skipDefaultConfigurationLookup(boolean z) {
        synchronized (f4181p) {
            f4183r = z;
        }
    }

    /* renamed from: a */
    public final boolean m1059a() {
        if (getLoadState() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final void m1060b(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f4184a.writeLock().lock();
        try {
            this.f4186c = 2;
            arrayList.addAll(this.f4185b);
            this.f4185b.clear();
            this.f4184a.writeLock().unlock();
            this.f4187d.post(new RunnableC0237d(arrayList, this.f4186c, th));
        } catch (Throwable th2) {
            this.f4184a.writeLock().unlock();
            throw th2;
        }
    }

    @NonNull
    public String getAssetSignature() {
        Preconditions.checkState(m1059a(), "Not initialized yet");
        String sourceSha = this.f4188e.f4234c.getMetadataList().sourceSha();
        if (sourceSha == null) {
            return "";
        }
        return sourceSha;
    }

    public int getEmojiEnd(@NonNull CharSequence charSequence, @IntRange(from = 0) int i) {
        C0242i c0242i = this.f4188e.f4233b;
        c0242i.getClass();
        if (i >= 0 && i < charSequence.length()) {
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                EmojiSpan[] emojiSpanArr = (EmojiSpan[]) spanned.getSpans(i, i + 1, EmojiSpan.class);
                if (emojiSpanArr.length > 0) {
                    return spanned.getSpanEnd(emojiSpanArr[0]);
                }
            }
            return ((i80) c0242i.m1084c(charSequence, Math.max(0, i - 16), Math.min(charSequence.length(), i + 16), Integer.MAX_VALUE, true, new i80(i))).f18335c;
        }
        return -1;
    }

    public int getEmojiMatch(@NonNull CharSequence charSequence, @IntRange(from = 0) int i) {
        Preconditions.checkState(m1059a(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.f4188e.f4233b.m1083b(charSequence, i);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiSpanIndicatorColor() {
        return this.f4195l;
    }

    public int getEmojiStart(@NonNull CharSequence charSequence, @IntRange(from = 0) int i) {
        C0242i c0242i = this.f4188e.f4233b;
        c0242i.getClass();
        if (i >= 0 && i < charSequence.length()) {
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                EmojiSpan[] emojiSpanArr = (EmojiSpan[]) spanned.getSpans(i, i + 1, EmojiSpan.class);
                if (emojiSpanArr.length > 0) {
                    return spanned.getSpanStart(emojiSpanArr[0]);
                }
            }
            return ((i80) c0242i.m1084c(charSequence, Math.max(0, i - 16), Math.min(charSequence.length(), i + 16), Integer.MAX_VALUE, true, new i80(i))).f18334b;
        }
        return -1;
    }

    public int getLoadState() {
        this.f4184a.readLock().lock();
        try {
            return this.f4186c;
        } finally {
            this.f4184a.readLock().unlock();
        }
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence charSequence) {
        Preconditions.checkState(m1059a(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        C0242i c0242i = this.f4188e.f4233b;
        return c0242i.m1083b(charSequence, c0242i.f4293b.f4218a.version()) == 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isEmojiSpanIndicatorEnabled() {
        return this.f4194k;
    }

    public void load() {
        boolean z = true;
        if (this.f4196m != 1) {
            z = false;
        }
        Preconditions.checkState(z, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (m1059a()) {
            return;
        }
        this.f4184a.writeLock().lock();
        try {
            if (this.f4186c == 0) {
                return;
            }
            this.f4186c = 0;
            this.f4184a.writeLock().unlock();
            C0236c c0236c = this.f4188e;
            EmojiCompat emojiCompat = (EmojiCompat) c0236c.f17677a;
            try {
                emojiCompat.f4189f.load(new C0235b(c0236c));
            } catch (Throwable th) {
                emojiCompat.m1060b(th);
            }
        } finally {
            this.f4184a.writeLock().unlock();
        }
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence charSequence) {
        return process(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public void registerInitCallback(@NonNull InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.f4184a.writeLock().lock();
        try {
            if (this.f4186c != 1 && this.f4186c != 2) {
                this.f4185b.add(initCallback);
                this.f4184a.writeLock().unlock();
            }
            this.f4187d.post(new RunnableC0237d(Arrays.asList((InitCallback) Preconditions.checkNotNull(initCallback, "initCallback cannot be null")), this.f4186c, null));
            this.f4184a.writeLock().unlock();
        } catch (Throwable th) {
            this.f4184a.writeLock().unlock();
            throw th;
        }
    }

    public void unregisterInitCallback(@NonNull InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        ReentrantReadWriteLock reentrantReadWriteLock = this.f4184a;
        reentrantReadWriteLock.writeLock().lock();
        try {
            this.f4185b.remove(initCallback);
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public void updateEditorInfo(@NonNull EditorInfo editorInfo) {
        if (m1059a() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            C0236c c0236c = this.f4188e;
            c0236c.getClass();
            editorInfo.extras.putInt(EDITOR_INFO_METAVERSION_KEY, c0236c.f4234c.f4218a.version());
            editorInfo.extras.putBoolean(EDITOR_INFO_REPLACE_ALL_KEY, ((EmojiCompat) c0236c.f17677a).f4191h);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static EmojiCompat init(@NonNull Context context, @Nullable DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory defaultEmojiCompatConfigFactory) {
        EmojiCompat emojiCompat;
        if (f4183r) {
            return f4182q;
        }
        if (defaultEmojiCompatConfigFactory == null) {
            defaultEmojiCompatConfigFactory = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(null);
        }
        Config create = defaultEmojiCompatConfigFactory.create(context);
        synchronized (f4181p) {
            try {
                if (!f4183r) {
                    if (create != null) {
                        init(create);
                    }
                    f4183r = true;
                }
                emojiCompat = f4182q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return emojiCompat;
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence charSequence, @IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        return process(charSequence, i, i2, Integer.MAX_VALUE);
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence charSequence, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        return process(charSequence, i, i2, i3, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00be A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:71:0x007b, B:74:0x0080, B:76:0x0084, B:78:0x0091, B:28:0x00ad, B:30:0x00b7, B:32:0x00ba, B:34:0x00be, B:36:0x00ce, B:38:0x00d1, B:43:0x00e0, B:49:0x00ee, B:50:0x0103, B:52:0x0118, B:26:0x00a3), top: B:70:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0118 A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:71:0x007b, B:74:0x0080, B:76:0x0084, B:78:0x0091, B:28:0x00ad, B:30:0x00b7, B:32:0x00ba, B:34:0x00be, B:36:0x00ce, B:38:0x00d1, B:43:0x00e0, B:49:0x00ee, B:50:0x0103, B:52:0x0118, B:26:0x00a3), top: B:70:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0124  */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object, i03] */
    @Nullable
    @CheckResult
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CharSequence process(@Nullable CharSequence charSequence, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, int i4) {
        boolean z;
        int i5;
        i03 i03Var;
        EmojiSpan[] emojiSpanArr;
        int i6 = i;
        int i7 = i2;
        Preconditions.checkState(m1059a(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(i6, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(i7, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(i3, "maxEmojiCount cannot be negative");
        Preconditions.checkArgument(i6 <= i7, "start should be <= than end");
        i03 i03Var2 = null;
        i03Var2 = null;
        if (charSequence == null) {
            return null;
        }
        Preconditions.checkArgument(i6 <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.checkArgument(i7 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i6 == i7) {
            return charSequence;
        }
        if (i4 != 1) {
            z = i4 != 2 ? this.f4191h : false;
        } else {
            z = true;
        }
        C0242i c0242i = this.f4188e.f4233b;
        c0242i.getClass();
        boolean z2 = charSequence instanceof SpannableBuilder;
        if (z2) {
            ((SpannableBuilder) charSequence).beginBatchEdit();
        }
        if (!z2) {
            try {
                if (!(charSequence instanceof Spannable)) {
                    if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i6 - 1, i7 + 1, EmojiSpan.class) <= i7) {
                        ?? obj = new Object();
                        obj.f18244a = false;
                        obj.f18245b = new SpannableString(charSequence);
                        i03Var2 = obj;
                    }
                    if (i03Var2 != null && (emojiSpanArr = (EmojiSpan[]) i03Var2.f18245b.getSpans(i6, i7, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
                        for (EmojiSpan emojiSpan : emojiSpanArr) {
                            int spanStart = i03Var2.f18245b.getSpanStart(emojiSpan);
                            int spanEnd = i03Var2.f18245b.getSpanEnd(emojiSpan);
                            if (spanStart != i7) {
                                i03Var2.removeSpan(emojiSpan);
                            }
                            i6 = Math.min(spanStart, i6);
                            i7 = Math.max(spanEnd, i7);
                        }
                    }
                    i5 = i7;
                    if (i6 != i5 && i6 < charSequence.length()) {
                        i03Var = (i03) c0242i.m1084c(charSequence, i6, i5, (i3 != Integer.MAX_VALUE || i03Var2 == null) ? i3 : i3 - ((EmojiSpan[]) i03Var2.f18245b.getSpans(0, i03Var2.f18245b.length(), EmojiSpan.class)).length, z, new C0241h(i03Var2, c0242i.f4292a));
                        if (i03Var != null) {
                            if (!z2) {
                                return charSequence;
                            }
                            return charSequence;
                        }
                        Spannable spannable = i03Var.f18245b;
                        if (z2) {
                            ((SpannableBuilder) charSequence).endBatchEdit();
                        }
                        return spannable;
                    }
                    return charSequence;
                }
            } finally {
                if (z2) {
                    ((SpannableBuilder) charSequence).endBatchEdit();
                }
            }
        }
        i03Var2 = new i03((Spannable) charSequence);
        if (i03Var2 != null) {
            while (r13 < r12) {
            }
        }
        i5 = i7;
        if (i6 != i5) {
            i03Var = (i03) c0242i.m1084c(charSequence, i6, i5, (i3 != Integer.MAX_VALUE || i03Var2 == null) ? i3 : i3 - ((EmojiSpan[]) i03Var2.f18245b.getSpans(0, i03Var2.f18245b.length(), EmojiSpan.class)).length, z, new C0241h(i03Var2, c0242i.f4292a));
            if (i03Var != null) {
            }
        }
        return charSequence;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static EmojiCompat reset(@Nullable EmojiCompat emojiCompat) {
        EmojiCompat emojiCompat2;
        synchronized (f4180o) {
            f4182q = emojiCompat;
            emojiCompat2 = f4182q;
        }
        return emojiCompat2;
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence charSequence, @IntRange(from = 0) int i) {
        Preconditions.checkState(m1059a(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.f4188e.f4233b.m1083b(charSequence, i) == 1;
    }

    @NonNull
    public static EmojiCompat init(@NonNull Config config) {
        EmojiCompat emojiCompat = f4182q;
        if (emojiCompat == null) {
            synchronized (f4180o) {
                try {
                    emojiCompat = f4182q;
                    if (emojiCompat == null) {
                        emojiCompat = new EmojiCompat(config);
                        f4182q = emojiCompat;
                    }
                } finally {
                }
            }
        }
        return emojiCompat;
    }
}
