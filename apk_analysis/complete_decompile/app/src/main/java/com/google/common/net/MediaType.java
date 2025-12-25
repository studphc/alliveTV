package com.google.common.net;

import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.hisona.allive.HttpRequest;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;
import p000.AbstractC1726qj;
import p000.cb0;
import p000.wm1;

@Immutable
@GwtCompatible
/* loaded from: classes2.dex */
public final class MediaType {

    /* renamed from: a */
    public final String f15183a;

    /* renamed from: b */
    public final String f15184b;

    /* renamed from: c */
    public final ImmutableListMultimap f15185c;

    /* renamed from: d */
    public String f15186d;

    /* renamed from: e */
    public int f15187e;

    /* renamed from: f */
    public Optional f15188f;

    /* renamed from: g */
    public static final ImmutableListMultimap f15177g = ImmutableListMultimap.m3917of(HttpRequest.PARAM_CHARSET, Ascii.toLowerCase(Charsets.UTF_8.name()));

    /* renamed from: h */
    public static final CharMatcher f15178h = CharMatcher.ascii().and(CharMatcher.javaIsoControl().negate()).and(CharMatcher.isNot(' ')).and(CharMatcher.noneOf("()<>@,;:\\\"/[]?="));

    /* renamed from: i */
    public static final CharMatcher f15179i = CharMatcher.ascii().and(CharMatcher.noneOf("\"\\\r"));

    /* renamed from: j */
    public static final CharMatcher f15180j = CharMatcher.anyOf(" \t\r\n");

    /* renamed from: k */
    public static final HashMap f15181k = Maps.newHashMap();
    public static final MediaType ANY_TYPE = m4236b("*", "*");
    public static final MediaType ANY_TEXT_TYPE = m4236b(MimeTypes.BASE_TYPE_TEXT, "*");
    public static final MediaType ANY_IMAGE_TYPE = m4236b(MimeTypes.BASE_TYPE_IMAGE, "*");
    public static final MediaType ANY_AUDIO_TYPE = m4236b(MimeTypes.BASE_TYPE_AUDIO, "*");
    public static final MediaType ANY_VIDEO_TYPE = m4236b(MimeTypes.BASE_TYPE_VIDEO, "*");
    public static final MediaType ANY_APPLICATION_TYPE = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "*");
    public static final MediaType ANY_FONT_TYPE = m4236b("font", "*");
    public static final MediaType CACHE_MANIFEST_UTF_8 = m4237c(MimeTypes.BASE_TYPE_TEXT, "cache-manifest");
    public static final MediaType CSS_UTF_8 = m4237c(MimeTypes.BASE_TYPE_TEXT, "css");
    public static final MediaType CSV_UTF_8 = m4237c(MimeTypes.BASE_TYPE_TEXT, "csv");
    public static final MediaType HTML_UTF_8 = m4237c(MimeTypes.BASE_TYPE_TEXT, "html");
    public static final MediaType I_CALENDAR_UTF_8 = m4237c(MimeTypes.BASE_TYPE_TEXT, "calendar");
    public static final MediaType PLAIN_TEXT_UTF_8 = m4237c(MimeTypes.BASE_TYPE_TEXT, "plain");
    public static final MediaType TEXT_JAVASCRIPT_UTF_8 = m4237c(MimeTypes.BASE_TYPE_TEXT, "javascript");
    public static final MediaType TSV_UTF_8 = m4237c(MimeTypes.BASE_TYPE_TEXT, "tab-separated-values");
    public static final MediaType VCARD_UTF_8 = m4237c(MimeTypes.BASE_TYPE_TEXT, "vcard");
    public static final MediaType WML_UTF_8 = m4237c(MimeTypes.BASE_TYPE_TEXT, "vnd.wap.wml");
    public static final MediaType XML_UTF_8 = m4237c(MimeTypes.BASE_TYPE_TEXT, "xml");
    public static final MediaType VTT_UTF_8 = m4237c(MimeTypes.BASE_TYPE_TEXT, "vtt");
    public static final MediaType BMP = m4236b(MimeTypes.BASE_TYPE_IMAGE, "bmp");
    public static final MediaType CRW = m4236b(MimeTypes.BASE_TYPE_IMAGE, "x-canon-crw");
    public static final MediaType GIF = m4236b(MimeTypes.BASE_TYPE_IMAGE, "gif");
    public static final MediaType ICO = m4236b(MimeTypes.BASE_TYPE_IMAGE, "vnd.microsoft.icon");
    public static final MediaType JPEG = m4236b(MimeTypes.BASE_TYPE_IMAGE, "jpeg");
    public static final MediaType PNG = m4236b(MimeTypes.BASE_TYPE_IMAGE, "png");
    public static final MediaType PSD = m4236b(MimeTypes.BASE_TYPE_IMAGE, "vnd.adobe.photoshop");
    public static final MediaType SVG_UTF_8 = m4237c(MimeTypes.BASE_TYPE_IMAGE, "svg+xml");
    public static final MediaType TIFF = m4236b(MimeTypes.BASE_TYPE_IMAGE, "tiff");
    public static final MediaType WEBP = m4236b(MimeTypes.BASE_TYPE_IMAGE, "webp");
    public static final MediaType HEIF = m4236b(MimeTypes.BASE_TYPE_IMAGE, "heif");
    public static final MediaType JP2K = m4236b(MimeTypes.BASE_TYPE_IMAGE, "jp2");
    public static final MediaType MP4_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "mp4");
    public static final MediaType MPEG_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "mpeg");
    public static final MediaType OGG_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "ogg");
    public static final MediaType WEBM_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "webm");
    public static final MediaType L16_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "l16");
    public static final MediaType L24_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "l24");
    public static final MediaType BASIC_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "basic");
    public static final MediaType AAC_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "aac");
    public static final MediaType VORBIS_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "vorbis");
    public static final MediaType WMA_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "x-ms-wma");
    public static final MediaType WAX_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "x-ms-wax");
    public static final MediaType VND_REAL_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "vnd.rn-realaudio");
    public static final MediaType VND_WAVE_AUDIO = m4236b(MimeTypes.BASE_TYPE_AUDIO, "vnd.wave");
    public static final MediaType MP4_VIDEO = m4236b(MimeTypes.BASE_TYPE_VIDEO, "mp4");
    public static final MediaType MPEG_VIDEO = m4236b(MimeTypes.BASE_TYPE_VIDEO, "mpeg");
    public static final MediaType OGG_VIDEO = m4236b(MimeTypes.BASE_TYPE_VIDEO, "ogg");
    public static final MediaType QUICKTIME = m4236b(MimeTypes.BASE_TYPE_VIDEO, "quicktime");
    public static final MediaType WEBM_VIDEO = m4236b(MimeTypes.BASE_TYPE_VIDEO, "webm");
    public static final MediaType WMV = m4236b(MimeTypes.BASE_TYPE_VIDEO, "x-ms-wmv");
    public static final MediaType FLV_VIDEO = m4236b(MimeTypes.BASE_TYPE_VIDEO, "x-flv");
    public static final MediaType THREE_GPP_VIDEO = m4236b(MimeTypes.BASE_TYPE_VIDEO, "3gpp");
    public static final MediaType THREE_GPP2_VIDEO = m4236b(MimeTypes.BASE_TYPE_VIDEO, "3gpp2");
    public static final MediaType APPLICATION_XML_UTF_8 = m4237c(MimeTypes.BASE_TYPE_APPLICATION, "xml");
    public static final MediaType ATOM_UTF_8 = m4237c(MimeTypes.BASE_TYPE_APPLICATION, "atom+xml");
    public static final MediaType BZIP2 = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "x-bzip2");
    public static final MediaType DART_UTF_8 = m4237c(MimeTypes.BASE_TYPE_APPLICATION, "dart");
    public static final MediaType APPLE_PASSBOOK = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.apple.pkpass");
    public static final MediaType EOT = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.ms-fontobject");
    public static final MediaType EPUB = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "epub+zip");
    public static final MediaType FORM_DATA = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "x-www-form-urlencoded");
    public static final MediaType KEY_ARCHIVE = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "pkcs12");
    public static final MediaType APPLICATION_BINARY = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "binary");
    public static final MediaType GEO_JSON = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "geo+json");
    public static final MediaType GZIP = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "x-gzip");
    public static final MediaType HAL_JSON = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "hal+json");
    public static final MediaType JAVASCRIPT_UTF_8 = m4237c(MimeTypes.BASE_TYPE_APPLICATION, "javascript");
    public static final MediaType JOSE = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "jose");
    public static final MediaType JOSE_JSON = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "jose+json");
    public static final MediaType JSON_UTF_8 = m4237c(MimeTypes.BASE_TYPE_APPLICATION, "json");
    public static final MediaType MANIFEST_JSON_UTF_8 = m4237c(MimeTypes.BASE_TYPE_APPLICATION, "manifest+json");
    public static final MediaType KML = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.google-earth.kml+xml");
    public static final MediaType KMZ = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.google-earth.kmz");
    public static final MediaType MBOX = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "mbox");
    public static final MediaType APPLE_MOBILE_CONFIG = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "x-apple-aspen-config");
    public static final MediaType MICROSOFT_EXCEL = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.ms-excel");
    public static final MediaType MICROSOFT_OUTLOOK = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.ms-outlook");
    public static final MediaType MICROSOFT_POWERPOINT = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.ms-powerpoint");
    public static final MediaType MICROSOFT_WORD = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "msword");
    public static final MediaType MEDIA_PRESENTATION_DESCRIPTION = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "dash+xml");
    public static final MediaType WASM_APPLICATION = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "wasm");
    public static final MediaType NACL_APPLICATION = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "x-nacl");
    public static final MediaType NACL_PORTABLE_APPLICATION = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "x-pnacl");
    public static final MediaType OCTET_STREAM = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "octet-stream");
    public static final MediaType OGG_CONTAINER = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "ogg");
    public static final MediaType OOXML_DOCUMENT = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final MediaType OOXML_PRESENTATION = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final MediaType OOXML_SHEET = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final MediaType OPENDOCUMENT_GRAPHICS = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.oasis.opendocument.graphics");
    public static final MediaType OPENDOCUMENT_PRESENTATION = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.oasis.opendocument.presentation");
    public static final MediaType OPENDOCUMENT_SPREADSHEET = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.oasis.opendocument.spreadsheet");
    public static final MediaType OPENDOCUMENT_TEXT = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.oasis.opendocument.text");
    public static final MediaType OPENSEARCH_DESCRIPTION_UTF_8 = m4237c(MimeTypes.BASE_TYPE_APPLICATION, "opensearchdescription+xml");
    public static final MediaType PDF = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "pdf");
    public static final MediaType POSTSCRIPT = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "postscript");
    public static final MediaType PROTOBUF = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "protobuf");
    public static final MediaType RDF_XML_UTF_8 = m4237c(MimeTypes.BASE_TYPE_APPLICATION, "rdf+xml");
    public static final MediaType RTF_UTF_8 = m4237c(MimeTypes.BASE_TYPE_APPLICATION, "rtf");
    public static final MediaType SFNT = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "font-sfnt");
    public static final MediaType SHOCKWAVE_FLASH = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "x-shockwave-flash");
    public static final MediaType SKETCHUP = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.sketchup.skp");
    public static final MediaType SOAP_XML_UTF_8 = m4237c(MimeTypes.BASE_TYPE_APPLICATION, "soap+xml");
    public static final MediaType TAR = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "x-tar");
    public static final MediaType WOFF = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "font-woff");
    public static final MediaType WOFF2 = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "font-woff2");
    public static final MediaType XHTML_UTF_8 = m4237c(MimeTypes.BASE_TYPE_APPLICATION, "xhtml+xml");
    public static final MediaType XRD_UTF_8 = m4237c(MimeTypes.BASE_TYPE_APPLICATION, "xrd+xml");
    public static final MediaType ZIP = m4236b(MimeTypes.BASE_TYPE_APPLICATION, "zip");
    public static final MediaType FONT_COLLECTION = m4236b("font", "collection");
    public static final MediaType FONT_OTF = m4236b("font", "otf");
    public static final MediaType FONT_SFNT = m4236b("font", "sfnt");
    public static final MediaType FONT_TTF = m4236b("font", "ttf");
    public static final MediaType FONT_WOFF = m4236b("font", "woff");
    public static final MediaType FONT_WOFF2 = m4236b("font", "woff2");

    /* renamed from: l */
    public static final Joiner.MapJoiner f15182l = Joiner.m3766on("; ").withKeyValueSeparator("=");

    public MediaType(String str, String str2, ImmutableListMultimap immutableListMultimap) {
        this.f15183a = str;
        this.f15184b = str2;
        this.f15185c = immutableListMultimap;
    }

    /* renamed from: a */
    public static MediaType m4235a(String str, String str2, Multimap multimap) {
        boolean z;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(multimap);
        String m4238d = m4238d(str);
        String m4238d2 = m4238d(str2);
        if ("*".equals(m4238d) && !"*".equals(m4238d2)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "A wildcard type cannot be used with a non-wildcard subtype");
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        for (Map.Entry entry : multimap.entries()) {
            String m4238d3 = m4238d((String) entry.getKey());
            String str3 = (String) entry.getValue();
            Preconditions.checkNotNull(str3);
            Preconditions.checkArgument(CharMatcher.ascii().matchesAllOf(str3), "parameter values must be ASCII: %s", str3);
            if (HttpRequest.PARAM_CHARSET.equals(m4238d3)) {
                str3 = Ascii.toLowerCase(str3);
            }
            builder.put((ImmutableListMultimap.Builder) m4238d3, str3);
        }
        MediaType mediaType = new MediaType(m4238d, m4238d2, builder.build());
        return (MediaType) MoreObjects.firstNonNull((MediaType) f15181k.get(mediaType), mediaType);
    }

    /* renamed from: b */
    public static MediaType m4236b(String str, String str2) {
        MediaType mediaType = new MediaType(str, str2, ImmutableListMultimap.m3916of());
        f15181k.put(mediaType, mediaType);
        mediaType.f15188f = Optional.absent();
        return mediaType;
    }

    /* renamed from: c */
    public static MediaType m4237c(String str, String str2) {
        MediaType mediaType = new MediaType(str, str2, f15177g);
        f15181k.put(mediaType, mediaType);
        mediaType.f15188f = Optional.m3770of(Charsets.UTF_8);
        return mediaType;
    }

    public static MediaType create(String str, String str2) {
        MediaType m4235a = m4235a(str, str2, ImmutableListMultimap.m3916of());
        m4235a.f15188f = Optional.absent();
        return m4235a;
    }

    /* renamed from: d */
    public static String m4238d(String str) {
        Preconditions.checkArgument(f15178h.matchesAllOf(str));
        Preconditions.checkArgument(!str.isEmpty());
        return Ascii.toLowerCase(str);
    }

    @CanIgnoreReturnValue
    public static MediaType parse(String str) {
        String m8064b;
        CharMatcher charMatcher = f15178h;
        Preconditions.checkNotNull(str);
        wm1 wm1Var = new wm1(str);
        try {
            String m8064b2 = wm1Var.m8064b(charMatcher);
            wm1Var.m8063a('/');
            String m8064b3 = wm1Var.m8064b(charMatcher);
            ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
            while (wm1Var.m8066e()) {
                CharMatcher charMatcher2 = f15180j;
                wm1Var.m8065c(charMatcher2);
                wm1Var.m8063a(';');
                wm1Var.m8065c(charMatcher2);
                String m8064b4 = wm1Var.m8064b(charMatcher);
                wm1Var.m8063a('=');
                if ('\"' == wm1Var.m8067f()) {
                    wm1Var.m8063a(Typography.quote);
                    StringBuilder sb = new StringBuilder();
                    while ('\"' != wm1Var.m8067f()) {
                        if ('\\' == wm1Var.m8067f()) {
                            wm1Var.m8063a('\\');
                            CharMatcher ascii = CharMatcher.ascii();
                            Preconditions.checkState(wm1Var.m8066e());
                            char m8067f = wm1Var.m8067f();
                            Preconditions.checkState(ascii.matches(m8067f));
                            wm1Var.f28243b++;
                            sb.append(m8067f);
                        } else {
                            sb.append(wm1Var.m8064b(f15179i));
                        }
                    }
                    m8064b = sb.toString();
                    wm1Var.m8063a(Typography.quote);
                } else {
                    m8064b = wm1Var.m8064b(charMatcher);
                }
                builder.put((ImmutableListMultimap.Builder) m8064b4, m8064b);
            }
            return m4235a(m8064b2, m8064b3, builder.build());
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(AbstractC1726qj.m7059o("Could not parse '", str, "'", AbstractC1726qj.m7052h(18, str)), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Optional<Charset> charset() {
        Optional<Charset> optional = this.f15188f;
        if (optional == null) {
            optional = Optional.absent();
            UnmodifiableIterator it = this.f15185c.get((ImmutableListMultimap) HttpRequest.PARAM_CHARSET).iterator();
            String str = null;
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str == null) {
                    optional = Optional.m3770of(Charset.forName(str2));
                    str = str2;
                } else if (!str.equals(str2)) {
                    throw new IllegalStateException(AbstractC1726qj.m7055k(AbstractC1726qj.m7052h(str.length() + 35, str2), "Multiple charset values defined: ", str, ", ", str2));
                }
            }
            this.f15188f = optional;
        }
        return optional;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaType)) {
            return false;
        }
        MediaType mediaType = (MediaType) obj;
        if (this.f15183a.equals(mediaType.f15183a) && this.f15184b.equals(mediaType.f15184b) && Maps.transformValues(this.f15185c.asMap(), new cb0(2)).equals(Maps.transformValues(mediaType.f15185c.asMap(), new cb0(2)))) {
            return true;
        }
        return false;
    }

    public boolean hasWildcard() {
        if (!"*".equals(this.f15183a) && !"*".equals(this.f15184b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.f15187e;
        if (i == 0) {
            int hashCode = Objects.hashCode(this.f15183a, this.f15184b, Maps.transformValues(this.f15185c.asMap(), new cb0(2)));
            this.f15187e = hashCode;
            return hashCode;
        }
        return i;
    }

    /* renamed from: is */
    public boolean m4239is(MediaType mediaType) {
        if (mediaType.f15183a.equals("*") || mediaType.f15183a.equals(this.f15183a)) {
            String str = mediaType.f15184b;
            if ((str.equals("*") || str.equals(this.f15184b)) && this.f15185c.entries().containsAll(mediaType.f15185c.entries())) {
                return true;
            }
        }
        return false;
    }

    public ImmutableListMultimap<String, String> parameters() {
        return this.f15185c;
    }

    public String subtype() {
        return this.f15184b;
    }

    public String toString() {
        String str = this.f15186d;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f15183a);
            sb.append('/');
            sb.append(this.f15184b);
            ImmutableListMultimap immutableListMultimap = this.f15185c;
            if (!immutableListMultimap.isEmpty()) {
                sb.append("; ");
                f15182l.appendTo(sb, Multimaps.transformValues((ListMultimap) immutableListMultimap, (Function) new cb0(1)).entries());
            }
            String sb2 = sb.toString();
            this.f15186d = sb2;
            return sb2;
        }
        return str;
    }

    public String type() {
        return this.f15183a;
    }

    public MediaType withCharset(Charset charset) {
        Preconditions.checkNotNull(charset);
        MediaType withParameter = withParameter(HttpRequest.PARAM_CHARSET, charset.name());
        withParameter.f15188f = Optional.m3770of(charset);
        return withParameter;
    }

    public MediaType withParameter(String str, String str2) {
        return withParameters(str, ImmutableSet.m3972of(str2));
    }

    public MediaType withParameters(Multimap<String, String> multimap) {
        return m4235a(this.f15183a, this.f15184b, multimap);
    }

    public MediaType withoutParameters() {
        if (this.f15185c.isEmpty()) {
            return this;
        }
        return create(this.f15183a, this.f15184b);
    }

    public MediaType withParameters(String str, Iterable<String> iterable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(iterable);
        String m4238d = m4238d(str);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        UnmodifiableIterator it = this.f15185c.entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str2 = (String) entry.getKey();
            if (!m4238d.equals(str2)) {
                builder.put((ImmutableListMultimap.Builder) str2, (String) entry.getValue());
            }
        }
        for (String str3 : iterable) {
            Preconditions.checkNotNull(str3);
            Preconditions.checkArgument(CharMatcher.ascii().matchesAllOf(str3), "parameter values must be ASCII: %s", str3);
            if (HttpRequest.PARAM_CHARSET.equals(m4238d)) {
                str3 = Ascii.toLowerCase(str3);
            }
            builder.put((ImmutableListMultimap.Builder) m4238d, str3);
        }
        MediaType mediaType = new MediaType(this.f15183a, this.f15184b, builder.build());
        if (!m4238d.equals(HttpRequest.PARAM_CHARSET)) {
            mediaType.f15188f = this.f15188f;
        }
        return (MediaType) MoreObjects.firstNonNull((MediaType) f15181k.get(mediaType), mediaType);
    }
}
