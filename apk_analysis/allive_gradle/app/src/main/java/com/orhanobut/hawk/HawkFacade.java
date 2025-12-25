package com.orhanobut.hawk;

/* loaded from: classes2.dex */
public interface HawkFacade {

    /* loaded from: classes2.dex */
    public static class EmptyHawkFacade implements HawkFacade {
        /* renamed from: a */
        public static void m4481a() {
            throw new IllegalStateException("Hawk is not built. Please call build() and wait the initialisation finishes.");
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public boolean contains(String str) {
            m4481a();
            throw null;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public long count() {
            m4481a();
            throw null;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public boolean delete(String str) {
            m4481a();
            throw null;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public boolean deleteAll() {
            m4481a();
            throw null;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public void destroy() {
            m4481a();
            throw null;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public <T> T get(String str) {
            m4481a();
            throw null;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public boolean isBuilt() {
            return false;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public <T> boolean put(String str, T t) {
            m4481a();
            throw null;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public <T> T get(String str, T t) {
            m4481a();
            throw null;
        }
    }

    boolean contains(String str);

    long count();

    boolean delete(String str);

    boolean deleteAll();

    void destroy();

    <T> T get(String str);

    <T> T get(String str, T t);

    boolean isBuilt();

    <T> boolean put(String str, T t);
}
