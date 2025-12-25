package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import p000.C1540m9;
import p000.CallableC1838tk;
import p000.RunnableC0006a5;
import p000.ge0;
import p000.he0;
import p000.j10;
import p000.sn2;
import p000.uw0;

/* loaded from: classes2.dex */
public class FirebaseInstallations implements FirebaseInstallationsApi {

    /* renamed from: m */
    public static final Object f15566m = new Object();

    /* renamed from: n */
    public static final j10 f15567n = new j10(1);

    /* renamed from: a */
    public final FirebaseApp f15568a;

    /* renamed from: b */
    public final FirebaseInstallationServiceClient f15569b;

    /* renamed from: c */
    public final PersistedInstallation f15570c;

    /* renamed from: d */
    public final Utils f15571d;

    /* renamed from: e */
    public final IidStore f15572e;

    /* renamed from: f */
    public final RandomFidGenerator f15573f;

    /* renamed from: g */
    public final Object f15574g;

    /* renamed from: h */
    public final ThreadPoolExecutor f15575h;

    /* renamed from: i */
    public final ThreadPoolExecutor f15576i;

    /* renamed from: j */
    public String f15577j;

    /* renamed from: k */
    public final HashSet f15578k;

    /* renamed from: l */
    public final ArrayList f15579l;

    public FirebaseInstallations(FirebaseApp firebaseApp, Provider provider) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        j10 j10Var = f15567n;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, timeUnit, linkedBlockingQueue, j10Var);
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = new FirebaseInstallationServiceClient(firebaseApp.getApplicationContext(), provider);
        PersistedInstallation persistedInstallation = new PersistedInstallation(firebaseApp);
        Utils utils = Utils.getInstance();
        IidStore iidStore = new IidStore(firebaseApp);
        RandomFidGenerator randomFidGenerator = new RandomFidGenerator();
        this.f15574g = new Object();
        this.f15578k = new HashSet();
        this.f15579l = new ArrayList();
        this.f15568a = firebaseApp;
        this.f15569b = firebaseInstallationServiceClient;
        this.f15570c = persistedInstallation;
        this.f15571d = utils;
        this.f15572e = iidStore;
        this.f15573f = randomFidGenerator;
        this.f15575h = threadPoolExecutor;
        this.f15576i = new ThreadPoolExecutor(0, 1, 30L, timeUnit, new LinkedBlockingQueue(), j10Var);
    }

    @NonNull
    public static FirebaseInstallations getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    /* renamed from: a */
    public final void m4379a(sn2 sn2Var) {
        synchronized (this.f15574g) {
            this.f15579l.add(sn2Var);
        }
    }

    /* JADX WARN: Finally extract failed */
    /* renamed from: b */
    public final void m4380b(boolean z) {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        String readIid;
        synchronized (f15566m) {
            try {
                C1540m9 m6091a = C1540m9.m6091a(this.f15568a.getApplicationContext());
                try {
                    readPersistedInstallationEntryValue = this.f15570c.readPersistedInstallationEntryValue();
                    if (readPersistedInstallationEntryValue.isNotGenerated()) {
                        FirebaseApp firebaseApp = this.f15568a;
                        boolean equals = firebaseApp.getName().equals("CHIME_ANDROID_SDK");
                        RandomFidGenerator randomFidGenerator = this.f15573f;
                        if ((!equals && !firebaseApp.isDefaultApp()) || !readPersistedInstallationEntryValue.shouldAttemptMigration()) {
                            readIid = randomFidGenerator.createRandomFid();
                        } else {
                            readIid = this.f15572e.readIid();
                            if (TextUtils.isEmpty(readIid)) {
                                readIid = randomFidGenerator.createRandomFid();
                            }
                        }
                        readPersistedInstallationEntryValue = this.f15570c.insertOrUpdatePersistedInstallationEntry(readPersistedInstallationEntryValue.withUnregisteredFid(readIid));
                    }
                    if (m6091a != null) {
                        m6091a.m6103m();
                    }
                } catch (Throwable th) {
                    if (m6091a != null) {
                        m6091a.m6103m();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z) {
            readPersistedInstallationEntryValue = readPersistedInstallationEntryValue.withClearedAuthToken();
        }
        m4387i(readPersistedInstallationEntryValue);
        this.f15576i.execute(new ge0(this, 1, z));
    }

    /* renamed from: c */
    public final PersistedInstallationEntry m4381c(PersistedInstallationEntry persistedInstallationEntry) {
        FirebaseApp firebaseApp = this.f15568a;
        TokenResult generateAuthToken = this.f15569b.generateAuthToken(firebaseApp.getOptions().getApiKey(), persistedInstallationEntry.getFirebaseInstallationId(), firebaseApp.getOptions().getProjectId(), persistedInstallationEntry.getRefreshToken());
        int i = he0.f18039b[generateAuthToken.getResponseCode().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    m4388j(null);
                    return persistedInstallationEntry.withNoGeneratedFid();
                }
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
            }
            return persistedInstallationEntry.withFisError("BAD CONFIG");
        }
        return persistedInstallationEntry.withAuthToken(generateAuthToken.getToken(), generateAuthToken.getTokenExpirationTimestamp(), this.f15571d.currentTimeInSecs());
    }

    /* JADX WARN: Finally extract failed */
    /* renamed from: d */
    public final PersistedInstallationEntry m4382d() {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        synchronized (f15566m) {
            try {
                C1540m9 m6091a = C1540m9.m6091a(this.f15568a.getApplicationContext());
                try {
                    readPersistedInstallationEntryValue = this.f15570c.readPersistedInstallationEntryValue();
                    if (m6091a != null) {
                        m6091a.m6103m();
                    }
                } catch (Throwable th) {
                    if (m6091a != null) {
                        m6091a.m6103m();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return readPersistedInstallationEntryValue;
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public Task<Void> delete() {
        return Tasks.call(this.f15575h, new CallableC1838tk(1, this));
    }

    /* JADX WARN: Finally extract failed */
    /* renamed from: e */
    public final void m4383e(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (f15566m) {
            try {
                C1540m9 m6091a = C1540m9.m6091a(this.f15568a.getApplicationContext());
                try {
                    this.f15570c.insertOrUpdatePersistedInstallationEntry(persistedInstallationEntry);
                    if (m6091a != null) {
                        m6091a.m6103m();
                    }
                } catch (Throwable th) {
                    if (m6091a != null) {
                        m6091a.m6103m();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public final void m4384f() {
        FirebaseApp firebaseApp = this.f15568a;
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApplicationId(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getProjectId(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApiKey(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        String applicationId = firebaseApp.getOptions().getApplicationId();
        Pattern pattern = Utils.f15584b;
        Preconditions.checkArgument(applicationId.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(Utils.f15584b.matcher(firebaseApp.getOptions().getApiKey()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    /* renamed from: g */
    public final PersistedInstallationEntry m4385g(PersistedInstallationEntry persistedInstallationEntry) {
        String str;
        if (persistedInstallationEntry.getFirebaseInstallationId() != null && persistedInstallationEntry.getFirebaseInstallationId().length() == 11) {
            str = this.f15572e.readToken();
        } else {
            str = null;
        }
        String str2 = str;
        FirebaseApp firebaseApp = this.f15568a;
        InstallationResponse createFirebaseInstallation = this.f15569b.createFirebaseInstallation(firebaseApp.getOptions().getApiKey(), persistedInstallationEntry.getFirebaseInstallationId(), firebaseApp.getOptions().getProjectId(), firebaseApp.getOptions().getApplicationId(), str2);
        int i = he0.f18038a[createFirebaseInstallation.getResponseCode().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return persistedInstallationEntry.withFisError("BAD CONFIG");
            }
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        return persistedInstallationEntry.withRegisteredFid(createFirebaseInstallation.getFid(), createFirebaseInstallation.getRefreshToken(), this.f15571d.currentTimeInSecs(), createFirebaseInstallation.getAuthToken().getToken(), createFirebaseInstallation.getAuthToken().getTokenExpirationTimestamp());
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public Task<String> getId() {
        String str;
        m4384f();
        synchronized (this) {
            str = this.f15577j;
        }
        if (str != null) {
            return Tasks.forResult(str);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        m4379a(new uw0(taskCompletionSource));
        Task<String> task = taskCompletionSource.getTask();
        this.f15575h.execute(new RunnableC0006a5(16, this));
        return task;
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public Task<InstallationTokenResult> getToken(boolean z) {
        m4384f();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        m4379a(new C1041c(this.f15571d, taskCompletionSource));
        Task<InstallationTokenResult> task = taskCompletionSource.getTask();
        this.f15575h.execute(new ge0(this, 0, z));
        return task;
    }

    /* renamed from: h */
    public final void m4386h(Exception exc) {
        synchronized (this.f15574g) {
            try {
                Iterator it = this.f15579l.iterator();
                while (it.hasNext()) {
                    if (((sn2) it.next()).mo4390a(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: i */
    public final void m4387i(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.f15574g) {
            try {
                Iterator it = this.f15579l.iterator();
                while (it.hasNext()) {
                    if (((sn2) it.next()).mo4391b(persistedInstallationEntry)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: j */
    public final synchronized void m4388j(String str) {
        this.f15577j = str;
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public synchronized FidListenerHandle registerFidListener(@NonNull FidListener fidListener) {
        this.f15578k.add(fidListener);
        return new C1540m9(10, this, fidListener, false);
    }

    @NonNull
    public static FirebaseInstallations getInstance(@NonNull FirebaseApp firebaseApp) {
        Preconditions.checkArgument(firebaseApp != null, "Null is not a valid value of FirebaseApp.");
        return (FirebaseInstallations) firebaseApp.get(FirebaseInstallationsApi.class);
    }
}
