package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaMetadataRetriever;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import okhttp3.internal.ws.WebSocketProtocol;
import p000.AbstractC1726qj;
import p000.sa0;
import p000.ta0;
import p000.ua0;
import p000.va0;
import p000.wa0;
import p000.xa0;
import p000.ye0;

/* loaded from: classes.dex */
public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;

    /* renamed from: S */
    public static final SimpleDateFormat f4330S;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;

    /* renamed from: T */
    public static final String[] f4331T;
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";

    @Deprecated
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";

    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";

    /* renamed from: U */
    public static final int[] f4332U;

    /* renamed from: V */
    public static final byte[] f4333V;

    /* renamed from: W */
    public static final wa0 f4334W;

    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;

    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;

    /* renamed from: X */
    public static final wa0[][] f4335X;

    /* renamed from: Y */
    public static final wa0[] f4336Y;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;

    /* renamed from: Z */
    public static final wa0 f4337Z;

    /* renamed from: a0 */
    public static final wa0 f4338a0;

    /* renamed from: b0 */
    public static final HashMap[] f4339b0;

    /* renamed from: c0 */
    public static final HashMap[] f4340c0;

    /* renamed from: d0 */
    public static final HashSet f4341d0;

    /* renamed from: e0 */
    public static final HashMap f4342e0;

    /* renamed from: f0 */
    public static final Charset f4343f0;

    /* renamed from: g0 */
    public static final byte[] f4344g0;

    /* renamed from: h0 */
    public static final byte[] f4345h0;

    /* renamed from: i0 */
    public static final Pattern f4346i0;

    /* renamed from: j0 */
    public static final Pattern f4347j0;

    /* renamed from: a */
    public String f4351a;

    /* renamed from: b */
    public FileDescriptor f4352b;

    /* renamed from: c */
    public AssetManager.AssetInputStream f4353c;

    /* renamed from: d */
    public int f4354d;

    /* renamed from: e */
    public final boolean f4355e;

    /* renamed from: f */
    public final HashMap[] f4356f;

    /* renamed from: g */
    public final HashSet f4357g;

    /* renamed from: h */
    public ByteOrder f4358h;

    /* renamed from: i */
    public boolean f4359i;

    /* renamed from: j */
    public boolean f4360j;

    /* renamed from: k */
    public boolean f4361k;

    /* renamed from: l */
    public int f4362l;

    /* renamed from: m */
    public int f4363m;

    /* renamed from: n */
    public byte[] f4364n;

    /* renamed from: o */
    public int f4365o;

    /* renamed from: p */
    public int f4366p;

    /* renamed from: q */
    public int f4367q;

    /* renamed from: r */
    public int f4368r;

    /* renamed from: s */
    public int f4369s;

    /* renamed from: t */
    public int f4370t;

    /* renamed from: u */
    public boolean f4371u;

    /* renamed from: v */
    public boolean f4372v;

    /* renamed from: w */
    public boolean f4373w;

    /* renamed from: x */
    public static final boolean f4348x = Log.isLoggable("ExifInterface", 3);

    /* renamed from: y */
    public static final List f4349y = Arrays.asList(1, 6, 3, 8);

    /* renamed from: z */
    public static final List f4350z = Arrays.asList(2, 7, 4, 5);
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};

    /* renamed from: A */
    public static final byte[] f4312A = {-1, -40, -1};

    /* renamed from: B */
    public static final byte[] f4313B = {102, 116, 121, 112};

    /* renamed from: C */
    public static final byte[] f4314C = {109, 105, 102, 49};

    /* renamed from: D */
    public static final byte[] f4315D = {104, 101, 105, 99};

    /* renamed from: E */
    public static final byte[] f4316E = {79, 76, 89, 77, 80, 0};

    /* renamed from: F */
    public static final byte[] f4317F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: G */
    public static final byte[] f4318G = {-119, 80, 78, 71, Ascii.f14455CR, 10, Ascii.SUB, 10};

    /* renamed from: H */
    public static final byte[] f4319H = {101, 88, 73, 102};

    /* renamed from: I */
    public static final byte[] f4320I = {73, 72, 68, 82};

    /* renamed from: J */
    public static final byte[] f4321J = {73, 69, 78, 68};

    /* renamed from: K */
    public static final byte[] f4322K = {82, 73, 70, 70};

    /* renamed from: L */
    public static final byte[] f4323L = {87, 69, 66, 80};

    /* renamed from: M */
    public static final byte[] f4324M = {69, 88, 73, 70};

    /* renamed from: N */
    public static final byte[] f4325N = "VP8X".getBytes(Charset.defaultCharset());

    /* renamed from: O */
    public static final byte[] f4326O = "VP8L".getBytes(Charset.defaultCharset());

    /* renamed from: P */
    public static final byte[] f4327P = "VP8 ".getBytes(Charset.defaultCharset());

    /* renamed from: Q */
    public static final byte[] f4328Q = "ANIM".getBytes(Charset.defaultCharset());

    /* renamed from: R */
    public static final byte[] f4329R = "ANMF".getBytes(Charset.defaultCharset());

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface ExifStreamType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface IfdType {
    }

    static {
        "XMP ".getBytes(Charset.defaultCharset());
        f4331T = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        f4332U = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        f4333V = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        wa0[] wa0VarArr = {new wa0(TAG_NEW_SUBFILE_TYPE, 254, 4), new wa0(TAG_SUBFILE_TYPE, 255, 4), new wa0(TAG_IMAGE_WIDTH, 256), new wa0(TAG_IMAGE_LENGTH, 257), new wa0(TAG_BITS_PER_SAMPLE, 258, 3), new wa0(TAG_COMPRESSION, 259, 3), new wa0(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new wa0(TAG_IMAGE_DESCRIPTION, 270, 2), new wa0(TAG_MAKE, 271, 2), new wa0(TAG_MODEL, 272, 2), new wa0(TAG_STRIP_OFFSETS, 273), new wa0(TAG_ORIENTATION, 274, 3), new wa0(TAG_SAMPLES_PER_PIXEL, 277, 3), new wa0(TAG_ROWS_PER_STRIP, 278), new wa0(TAG_STRIP_BYTE_COUNTS, 279), new wa0(TAG_X_RESOLUTION, 282, 5), new wa0(TAG_Y_RESOLUTION, 283, 5), new wa0(TAG_PLANAR_CONFIGURATION, 284, 3), new wa0(TAG_RESOLUTION_UNIT, 296, 3), new wa0(TAG_TRANSFER_FUNCTION, 301, 3), new wa0(TAG_SOFTWARE, 305, 2), new wa0(TAG_DATETIME, 306, 2), new wa0(TAG_ARTIST, 315, 2), new wa0(TAG_WHITE_POINT, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 5), new wa0(TAG_PRIMARY_CHROMATICITIES, 319, 5), new wa0("SubIFDPointer", 330, 4), new wa0(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new wa0(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new wa0(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new wa0(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new wa0(TAG_Y_CB_CR_POSITIONING, 531, 3), new wa0(TAG_REFERENCE_BLACK_WHITE, 532, 5), new wa0(TAG_COPYRIGHT, 33432, 2), new wa0("ExifIFDPointer", 34665, 4), new wa0("GPSInfoIFDPointer", 34853, 4), new wa0(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new wa0(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new wa0(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new wa0(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new wa0(TAG_RW2_ISO, 23, 3), new wa0(TAG_RW2_JPG_FROM_RAW, 46, 7), new wa0(TAG_XMP, TypedValues.TransitionType.TYPE_DURATION, 1)};
        wa0[] wa0VarArr2 = {new wa0(TAG_EXPOSURE_TIME, 33434, 5), new wa0(TAG_F_NUMBER, 33437, 5), new wa0(TAG_EXPOSURE_PROGRAM, 34850, 3), new wa0(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new wa0(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new wa0(TAG_OECF, 34856, 7), new wa0(TAG_SENSITIVITY_TYPE, 34864, 3), new wa0(TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new wa0(TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new wa0(TAG_ISO_SPEED, 34867, 4), new wa0(TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new wa0(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new wa0(TAG_EXIF_VERSION, 36864, 2), new wa0(TAG_DATETIME_ORIGINAL, 36867, 2), new wa0(TAG_DATETIME_DIGITIZED, 36868, 2), new wa0(TAG_OFFSET_TIME, 36880, 2), new wa0(TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new wa0(TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new wa0(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new wa0(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new wa0(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new wa0(TAG_APERTURE_VALUE, 37378, 5), new wa0(TAG_BRIGHTNESS_VALUE, 37379, 10), new wa0(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new wa0(TAG_MAX_APERTURE_VALUE, 37381, 5), new wa0(TAG_SUBJECT_DISTANCE, 37382, 5), new wa0(TAG_METERING_MODE, 37383, 3), new wa0(TAG_LIGHT_SOURCE, 37384, 3), new wa0(TAG_FLASH, 37385, 3), new wa0(TAG_FOCAL_LENGTH, 37386, 5), new wa0(TAG_SUBJECT_AREA, 37396, 3), new wa0(TAG_MAKER_NOTE, 37500, 7), new wa0(TAG_USER_COMMENT, 37510, 7), new wa0(TAG_SUBSEC_TIME, 37520, 2), new wa0(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new wa0(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new wa0(TAG_FLASHPIX_VERSION, 40960, 7), new wa0(TAG_COLOR_SPACE, 40961, 3), new wa0(TAG_PIXEL_X_DIMENSION, 40962), new wa0(TAG_PIXEL_Y_DIMENSION, 40963), new wa0(TAG_RELATED_SOUND_FILE, 40964, 2), new wa0("InteroperabilityIFDPointer", 40965, 4), new wa0(TAG_FLASH_ENERGY, 41483, 5), new wa0(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new wa0(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new wa0(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new wa0(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new wa0(TAG_SUBJECT_LOCATION, 41492, 3), new wa0(TAG_EXPOSURE_INDEX, 41493, 5), new wa0(TAG_SENSING_METHOD, 41495, 3), new wa0(TAG_FILE_SOURCE, 41728, 7), new wa0(TAG_SCENE_TYPE, 41729, 7), new wa0(TAG_CFA_PATTERN, 41730, 7), new wa0(TAG_CUSTOM_RENDERED, 41985, 3), new wa0(TAG_EXPOSURE_MODE, 41986, 3), new wa0(TAG_WHITE_BALANCE, 41987, 3), new wa0(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new wa0(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new wa0(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new wa0(TAG_GAIN_CONTROL, 41991, 3), new wa0(TAG_CONTRAST, 41992, 3), new wa0(TAG_SATURATION, 41993, 3), new wa0(TAG_SHARPNESS, 41994, 3), new wa0(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new wa0(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new wa0(TAG_IMAGE_UNIQUE_ID, 42016, 2), new wa0("CameraOwnerName", 42032, 2), new wa0(TAG_BODY_SERIAL_NUMBER, 42033, 2), new wa0(TAG_LENS_SPECIFICATION, 42034, 5), new wa0(TAG_LENS_MAKE, 42035, 2), new wa0(TAG_LENS_MODEL, 42036, 2), new wa0(TAG_GAMMA, 42240, 5), new wa0(TAG_DNG_VERSION, 50706, 1), new wa0(TAG_DEFAULT_CROP_SIZE, 50720)};
        wa0[] wa0VarArr3 = {new wa0(TAG_GPS_VERSION_ID, 0, 1), new wa0(TAG_GPS_LATITUDE_REF, 1, 2), new wa0(TAG_GPS_LATITUDE, 2, 5), new wa0(TAG_GPS_LONGITUDE_REF, 3, 2), new wa0(TAG_GPS_LONGITUDE, 4, 5), new wa0(TAG_GPS_ALTITUDE_REF, 5, 1), new wa0(TAG_GPS_ALTITUDE, 6, 5), new wa0(TAG_GPS_TIMESTAMP, 7, 5), new wa0(TAG_GPS_SATELLITES, 8, 2), new wa0(TAG_GPS_STATUS, 9, 2), new wa0(TAG_GPS_MEASURE_MODE, 10, 2), new wa0(TAG_GPS_DOP, 11, 5), new wa0(TAG_GPS_SPEED_REF, 12, 2), new wa0(TAG_GPS_SPEED, 13, 5), new wa0(TAG_GPS_TRACK_REF, 14, 2), new wa0(TAG_GPS_TRACK, 15, 5), new wa0(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new wa0(TAG_GPS_IMG_DIRECTION, 17, 5), new wa0(TAG_GPS_MAP_DATUM, 18, 2), new wa0(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new wa0(TAG_GPS_DEST_LATITUDE, 20, 5), new wa0(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new wa0(TAG_GPS_DEST_LONGITUDE, 22, 5), new wa0(TAG_GPS_DEST_BEARING_REF, 23, 2), new wa0(TAG_GPS_DEST_BEARING, 24, 5), new wa0(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new wa0(TAG_GPS_DEST_DISTANCE, 26, 5), new wa0(TAG_GPS_PROCESSING_METHOD, 27, 7), new wa0(TAG_GPS_AREA_INFORMATION, 28, 7), new wa0(TAG_GPS_DATESTAMP, 29, 2), new wa0(TAG_GPS_DIFFERENTIAL, 30, 3), new wa0(TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        wa0[] wa0VarArr4 = {new wa0(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        wa0[] wa0VarArr5 = {new wa0(TAG_NEW_SUBFILE_TYPE, 254, 4), new wa0(TAG_SUBFILE_TYPE, 255, 4), new wa0(TAG_THUMBNAIL_IMAGE_WIDTH, 256), new wa0(TAG_THUMBNAIL_IMAGE_LENGTH, 257), new wa0(TAG_BITS_PER_SAMPLE, 258, 3), new wa0(TAG_COMPRESSION, 259, 3), new wa0(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new wa0(TAG_IMAGE_DESCRIPTION, 270, 2), new wa0(TAG_MAKE, 271, 2), new wa0(TAG_MODEL, 272, 2), new wa0(TAG_STRIP_OFFSETS, 273), new wa0(TAG_THUMBNAIL_ORIENTATION, 274, 3), new wa0(TAG_SAMPLES_PER_PIXEL, 277, 3), new wa0(TAG_ROWS_PER_STRIP, 278), new wa0(TAG_STRIP_BYTE_COUNTS, 279), new wa0(TAG_X_RESOLUTION, 282, 5), new wa0(TAG_Y_RESOLUTION, 283, 5), new wa0(TAG_PLANAR_CONFIGURATION, 284, 3), new wa0(TAG_RESOLUTION_UNIT, 296, 3), new wa0(TAG_TRANSFER_FUNCTION, 301, 3), new wa0(TAG_SOFTWARE, 305, 2), new wa0(TAG_DATETIME, 306, 2), new wa0(TAG_ARTIST, 315, 2), new wa0(TAG_WHITE_POINT, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 5), new wa0(TAG_PRIMARY_CHROMATICITIES, 319, 5), new wa0("SubIFDPointer", 330, 4), new wa0(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new wa0(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new wa0(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new wa0(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new wa0(TAG_Y_CB_CR_POSITIONING, 531, 3), new wa0(TAG_REFERENCE_BLACK_WHITE, 532, 5), new wa0(TAG_COPYRIGHT, 33432, 2), new wa0("ExifIFDPointer", 34665, 4), new wa0("GPSInfoIFDPointer", 34853, 4), new wa0(TAG_DNG_VERSION, 50706, 1), new wa0(TAG_DEFAULT_CROP_SIZE, 50720)};
        f4334W = new wa0(TAG_STRIP_OFFSETS, 273, 3);
        f4335X = new wa0[][]{wa0VarArr, wa0VarArr2, wa0VarArr3, wa0VarArr4, wa0VarArr5, wa0VarArr, new wa0[]{new wa0(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new wa0("CameraSettingsIFDPointer", 8224, 4), new wa0("ImageProcessingIFDPointer", 8256, 4)}, new wa0[]{new wa0(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new wa0(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)}, new wa0[]{new wa0(TAG_ORF_ASPECT_FRAME, 4371, 3)}, new wa0[]{new wa0(TAG_COLOR_SPACE, 55, 3)}};
        f4336Y = new wa0[]{new wa0("SubIFDPointer", 330, 4), new wa0("ExifIFDPointer", 34665, 4), new wa0("GPSInfoIFDPointer", 34853, 4), new wa0("InteroperabilityIFDPointer", 40965, 4), new wa0("CameraSettingsIFDPointer", 8224, 1), new wa0("ImageProcessingIFDPointer", 8256, 1)};
        f4337Z = new wa0(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4);
        f4338a0 = new wa0(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
        f4339b0 = new HashMap[10];
        f4340c0 = new HashMap[10];
        f4341d0 = new HashSet(Arrays.asList(TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP));
        f4342e0 = new HashMap();
        Charset forName = Charset.forName(C0643C.ASCII_NAME);
        f4343f0 = forName;
        f4344g0 = "Exif\u0000\u0000".getBytes(forName);
        f4345h0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        f4330S = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            wa0[][] wa0VarArr6 = f4335X;
            if (i < wa0VarArr6.length) {
                f4339b0[i] = new HashMap();
                f4340c0[i] = new HashMap();
                for (wa0 wa0Var : wa0VarArr6[i]) {
                    f4339b0[i].put(Integer.valueOf(wa0Var.f28112a), wa0Var);
                    f4340c0[i].put(wa0Var.f28113b, wa0Var);
                }
                i++;
            } else {
                HashMap hashMap = f4342e0;
                wa0[] wa0VarArr7 = f4336Y;
                hashMap.put(Integer.valueOf(wa0VarArr7[0].f28112a), 5);
                hashMap.put(Integer.valueOf(wa0VarArr7[1].f28112a), 1);
                hashMap.put(Integer.valueOf(wa0VarArr7[2].f28112a), 2);
                hashMap.put(Integer.valueOf(wa0VarArr7[3].f28112a), 3);
                hashMap.put(Integer.valueOf(wa0VarArr7[4].f28112a), 7);
                hashMap.put(Integer.valueOf(wa0VarArr7[5].f28112a), 8);
                f4346i0 = Pattern.compile(".*[1-9].*");
                f4347j0 = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
        }
    }

    public ExifInterface(@NonNull File file) {
        wa0[][] wa0VarArr = f4335X;
        this.f4356f = new HashMap[wa0VarArr.length];
        this.f4357g = new HashSet(wa0VarArr.length);
        this.f4358h = ByteOrder.BIG_ENDIAN;
        if (file != null) {
            m1129x(file.getAbsolutePath());
            return;
        }
        throw new NullPointerException("file cannot be null");
    }

    /* renamed from: B */
    public static long m1089B(String str, String str2) {
        if (str != null && f4346i0.matcher(str).matches()) {
            try {
                Date parse = f4330S.parse(str, new ParsePosition(0));
                if (parse == null) {
                    return -1L;
                }
                long time = parse.getTime();
                if (str2 != null) {
                    try {
                        long parseLong = Long.parseLong(str2);
                        while (parseLong > 1000) {
                            parseLong /= 10;
                        }
                        return time + parseLong;
                    } catch (NumberFormatException unused) {
                        return time;
                    }
                }
                return time;
            } catch (IllegalArgumentException unused2) {
            }
        }
        return -1L;
    }

    /* renamed from: E */
    public static ByteOrder m1090E(ta0 ta0Var) {
        short readShort = ta0Var.readShort();
        boolean z = f4348x;
        if (readShort != 18761) {
            if (readShort == 19789) {
                if (z) {
                    Log.d("ExifInterface", "readExifSegment: Byte Align MM");
                }
                return ByteOrder.BIG_ENDIAN;
            }
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
        if (z) {
            Log.d("ExifInterface", "readExifSegment: Byte Align II");
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    /* renamed from: b */
    public static String m1091b(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static void m1092c(FileDescriptor fileDescriptor) {
        try {
            Os.close(fileDescriptor);
        } catch (Exception unused) {
            Log.e("ExifInterface", "Error closing fd.");
        }
    }

    /* renamed from: d */
    public static void m1093d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: e */
    public static String m1094e(double d) {
        long j = (long) d;
        double d2 = d - j;
        long j2 = (long) (d2 * 60.0d);
        return j + "/1," + j2 + "/1," + Math.round((d2 - (j2 / 60.0d)) * 3600.0d * 1.0E7d) + "/10000000";
    }

    /* renamed from: f */
    public static double m1095f(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            double parseDouble = Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim());
            String[] split3 = split[1].split("/", -1);
            double parseDouble2 = Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim());
            String[] split4 = split[2].split("/", -1);
            double parseDouble3 = ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d) + (parseDouble2 / 60.0d) + parseDouble;
            if (!str2.equals(LATITUDE_SOUTH) && !str2.equals(LONGITUDE_WEST)) {
                if (!str2.equals("N") && !str2.equals(LONGITUDE_EAST)) {
                    throw new IllegalArgumentException();
                }
                return parseDouble3;
            }
            return -parseDouble3;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public static long[] m1096g(Serializable serializable) {
        if (serializable instanceof int[]) {
            int[] iArr = (int[]) serializable;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = iArr[i];
            }
            return jArr;
        }
        if (serializable instanceof long[]) {
            return (long[]) serializable;
        }
        return null;
    }

    /* renamed from: h */
    public static void m1097h(InputStream inputStream, ua0 ua0Var, int i) {
        byte[] bArr = new byte[8192];
        while (i > 0) {
            int min = Math.min(i, 8192);
            int read = inputStream.read(bArr, 0, min);
            if (read == min) {
                i -= read;
                ua0Var.write(bArr, 0, read);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }

    /* renamed from: i */
    public static void m1098i(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static boolean isSupportedMimeType(@NonNull String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            char c = 65535;
            switch (lowerCase.hashCode()) {
                case -1875291391:
                    if (lowerCase.equals("image/x-fuji-raf")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1635437028:
                    if (lowerCase.equals("image/x-samsung-srw")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1594371159:
                    if (lowerCase.equals("image/x-sony-arw")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1487464693:
                    if (lowerCase.equals("image/heic")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1487464690:
                    if (lowerCase.equals("image/heif")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1487394660:
                    if (lowerCase.equals(MimeTypes.IMAGE_JPEG)) {
                        c = 5;
                        break;
                    }
                    break;
                case -1487018032:
                    if (lowerCase.equals("image/webp")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1423313290:
                    if (lowerCase.equals("image/x-adobe-dng")) {
                        c = 7;
                        break;
                    }
                    break;
                case -985160897:
                    if (lowerCase.equals("image/x-panasonic-rw2")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -879258763:
                    if (lowerCase.equals("image/png")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -332763809:
                    if (lowerCase.equals("image/x-pentax-pef")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1378106698:
                    if (lowerCase.equals("image/x-olympus-orf")) {
                        c = 11;
                        break;
                    }
                    break;
                case 2099152104:
                    if (lowerCase.equals("image/x-nikon-nef")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 2099152524:
                    if (lowerCase.equals("image/x-nikon-nrw")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 2111234748:
                    if (lowerCase.equals("image/x-canon-cr2")) {
                        c = 14;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                    return true;
                default:
                    return false;
            }
        }
        throw new NullPointerException("mimeType shouldn't be null");
    }

    /* renamed from: j */
    public static void m1099j(ta0 ta0Var, ua0 ua0Var, byte[] bArr, byte[] bArr2) {
        String concat;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (ta0Var.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = f4343f0;
                sb.append(new String(bArr, charset));
                if (bArr2 == null) {
                    concat = "";
                } else {
                    concat = " or ".concat(new String(bArr2, charset));
                }
                sb.append(concat);
                throw new IOException(sb.toString());
            }
            int readInt = ta0Var.readInt();
            ua0Var.write(bArr3);
            ua0Var.m7686b(readInt);
            if (readInt % 2 == 1) {
                readInt++;
            }
            m1097h(ta0Var, ua0Var, readInt);
            if (!Arrays.equals(bArr3, bArr)) {
                if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: v */
    public static Pair m1100v(String str) {
        int intValue;
        int i;
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair m1100v = m1100v(split[0]);
            if (((Integer) m1100v.first).intValue() == 2) {
                return m1100v;
            }
            for (int i2 = 1; i2 < split.length; i2++) {
                Pair m1100v2 = m1100v(split[i2]);
                if (!((Integer) m1100v2.first).equals(m1100v.first) && !((Integer) m1100v2.second).equals(m1100v.first)) {
                    intValue = -1;
                } else {
                    intValue = ((Integer) m1100v.first).intValue();
                }
                if (((Integer) m1100v.second).intValue() != -1 && (((Integer) m1100v2.first).equals(m1100v.second) || ((Integer) m1100v2.second).equals(m1100v.second))) {
                    i = ((Integer) m1100v.second).intValue();
                } else {
                    i = -1;
                }
                if (intValue == -1 && i == -1) {
                    return new Pair(2, -1);
                }
                if (intValue == -1) {
                    m1100v = new Pair(Integer.valueOf(i), -1);
                } else if (i == -1) {
                    m1100v = new Pair(Integer.valueOf(intValue), -1);
                }
            }
            return m1100v;
        }
        if (str.contains("/")) {
            String[] split2 = str.split("/", -1);
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble >= 0 && parseDouble2 >= 0) {
                        if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                            return new Pair(10, 5);
                        }
                        return new Pair(5, -1);
                    }
                    return new Pair(10, -1);
                } catch (NumberFormatException unused) {
                }
            }
            return new Pair(2, -1);
        }
        try {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong >= 0 && parseLong <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                    return new Pair(3, 4);
                }
                if (parseLong < 0) {
                    return new Pair(9, -1);
                }
                return new Pair(4, -1);
            } catch (NumberFormatException unused2) {
                return new Pair(2, -1);
            }
        } catch (NumberFormatException unused3) {
            Double.parseDouble(str);
            return new Pair(12, -1);
        }
    }

    /* renamed from: y */
    public static boolean m1101y(FileDescriptor fileDescriptor) {
        try {
            Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (f4348x) {
                Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                return false;
            }
            return false;
        }
    }

    /* renamed from: A */
    public final void m1102A(InputStream inputStream) {
        boolean z = f4348x;
        for (int i = 0; i < f4335X.length; i++) {
            try {
                try {
                    this.f4356f[i] = new HashMap();
                } catch (IOException e) {
                    this.f4371u = false;
                    if (z) {
                        Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                    }
                    m1116a();
                    if (!z) {
                        return;
                    }
                }
            } catch (Throwable th) {
                m1116a();
                if (z) {
                    m1104D();
                }
                throw th;
            }
        }
        boolean z2 = this.f4355e;
        if (!z2) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.f4354d = m1120n(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        ta0 ta0Var = new ta0(inputStream);
        if (!z2) {
            switch (this.f4354d) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 8:
                case 11:
                    m1124r(ta0Var);
                    break;
                case 4:
                    m1119m(ta0Var, 0, 0);
                    break;
                case 7:
                    m1121o(ta0Var);
                    break;
                case 9:
                    m1123q(ta0Var);
                    break;
                case 10:
                    m1125s(ta0Var);
                    break;
                case 12:
                    m1118l(ta0Var);
                    break;
                case 13:
                    m1122p(ta0Var);
                    break;
                case 14:
                    m1127u(ta0Var);
                    break;
            }
        } else {
            m1126t(ta0Var);
        }
        m1111L(ta0Var);
        this.f4371u = true;
        m1116a();
        if (!z) {
            return;
        }
        m1104D();
    }

    /* renamed from: C */
    public final void m1103C(ta0 ta0Var, int i) {
        ByteOrder m1090E = m1090E(ta0Var);
        this.f4358h = m1090E;
        ta0Var.f26742b = m1090E;
        int readUnsignedShort = ta0Var.readUnsignedShort();
        int i2 = this.f4354d;
        if (i2 != 7 && i2 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = ta0Var.readInt();
        if (readInt >= 8 && readInt < i) {
            int i3 = readInt - 8;
            if (i3 > 0 && ta0Var.skipBytes(i3) != i3) {
                throw new IOException(ye0.m8291k(i3, "Couldn't jump to first Ifd: "));
            }
            return;
        }
        throw new IOException(ye0.m8291k(readInt, "Invalid first Ifd offset: "));
    }

    /* renamed from: D */
    public final void m1104D() {
        int i = 0;
        while (true) {
            HashMap[] hashMapArr = this.f4356f;
            if (i < hashMapArr.length) {
                StringBuilder m8299s = ye0.m8299s(i, "The size of tag group[", "]: ");
                m8299s.append(hashMapArr[i].size());
                Log.d("ExifInterface", m8299s.toString());
                for (Map.Entry entry : hashMapArr[i].entrySet()) {
                    va0 va0Var = (va0) entry.getValue();
                    Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + va0Var.toString() + ", tagValue: '" + va0Var.m7894i(this.f4358h) + "'");
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: F */
    public final void m1105F(int i, byte[] bArr) {
        ta0 ta0Var = new ta0(bArr);
        m1103C(ta0Var, bArr.length);
        m1106G(ta0Var, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02c2  */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1106G(ta0 ta0Var, int i) {
        HashMap[] hashMapArr;
        String str;
        short s;
        HashSet hashSet;
        int i2;
        int i3;
        int i4;
        long j;
        boolean z;
        int i5;
        int i6;
        long j2;
        int i7;
        int i8;
        int i9;
        wa0 wa0Var;
        long j3;
        HashSet hashSet2;
        boolean z2;
        String str2;
        int readUnsignedShort;
        long j4;
        HashSet hashSet3;
        long j5;
        String str3;
        int i10 = i;
        Integer valueOf = Integer.valueOf(ta0Var.f26744d);
        HashSet hashSet4 = this.f4357g;
        hashSet4.add(valueOf);
        int i11 = ta0Var.f26744d + 2;
        int i12 = ta0Var.f26743c;
        if (i11 > i12) {
            return;
        }
        short readShort = ta0Var.readShort();
        boolean z3 = f4348x;
        String str4 = "ExifInterface";
        if (z3) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + ((int) readShort));
        }
        if ((readShort * 12) + ta0Var.f26744d <= i12 && readShort > 0) {
            short s2 = 0;
            while (true) {
                hashMapArr = this.f4356f;
                if (s2 >= readShort) {
                    break;
                }
                int readUnsignedShort2 = ta0Var.readUnsignedShort();
                int readUnsignedShort3 = ta0Var.readUnsignedShort();
                int readInt = ta0Var.readInt();
                long j6 = ta0Var.f26744d + 4;
                short s3 = readShort;
                wa0 wa0Var2 = (wa0) f4339b0[i10].get(Integer.valueOf(readUnsignedShort2));
                if (z3) {
                    Integer valueOf2 = Integer.valueOf(i);
                    Integer valueOf3 = Integer.valueOf(readUnsignedShort2);
                    s = s2;
                    if (wa0Var2 != null) {
                        str3 = wa0Var2.f28113b;
                    } else {
                        str3 = null;
                    }
                    hashSet = hashSet4;
                    i2 = i12;
                    Log.d(str4, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", valueOf2, valueOf3, str3, Integer.valueOf(readUnsignedShort3), Integer.valueOf(readInt)));
                } else {
                    s = s2;
                    hashSet = hashSet4;
                    i2 = i12;
                }
                if (wa0Var2 == null) {
                    if (z3) {
                        Log.d(str4, "Skip the tag entry since tag number is not defined: " + readUnsignedShort2);
                    }
                } else {
                    if (readUnsignedShort3 > 0) {
                        if (readUnsignedShort3 < f4332U.length) {
                            int i13 = wa0Var2.f28114c;
                            if (i13 != 7 && readUnsignedShort3 != 7 && i13 != readUnsignedShort3 && (i5 = wa0Var2.f28115d) != readUnsignedShort3 && (((i13 != 4 && i5 != 4) || readUnsignedShort3 != 3) && ((i13 != 9 && i5 != 9) || readUnsignedShort3 != 8))) {
                                if ((i13 != 12 && i5 != 12) || readUnsignedShort3 != 11) {
                                    if (z3) {
                                        Log.d(str4, "Skip the tag entry since data format (" + f4331T[readUnsignedShort3] + ") is unexpected for tag: " + wa0Var2.f28113b);
                                    }
                                }
                            }
                            if (readUnsignedShort3 == 7) {
                                i4 = readUnsignedShort2;
                                readUnsignedShort3 = i13;
                            } else {
                                i4 = readUnsignedShort2;
                            }
                            i3 = i4;
                            j = readInt * r9[readUnsignedShort3];
                            if (j >= 0 && j <= 2147483647L) {
                                z = true;
                                if (z) {
                                }
                                str2 = str4;
                                s2 = (short) (s + 1);
                                hashSet4 = hashSet2;
                                z3 = z2;
                                i12 = i9;
                                readShort = s3;
                                str4 = str2;
                                i10 = i;
                            } else {
                                if (z3) {
                                    Log.d(str4, "Skip the tag entry since the number of components is invalid: " + readInt);
                                }
                                z = false;
                                if (z) {
                                    ta0Var.m7468a(j6);
                                    z2 = z3;
                                    hashSet2 = hashSet;
                                    i9 = i2;
                                } else {
                                    if (j > 4) {
                                        int readInt2 = ta0Var.readInt();
                                        i6 = readUnsignedShort3;
                                        if (z3) {
                                            i8 = i3;
                                            Log.d(str4, "seek to data offset: " + readInt2);
                                        } else {
                                            i8 = i3;
                                        }
                                        int i14 = this.f4354d;
                                        if (i14 == 7) {
                                            if (TAG_MAKER_NOTE.equals(wa0Var2.f28113b)) {
                                                this.f4367q = readInt2;
                                            } else if (i10 == 6 && TAG_ORF_THUMBNAIL_IMAGE.equals(wa0Var2.f28113b)) {
                                                this.f4368r = readInt2;
                                                this.f4369s = readInt;
                                                va0 m7890e = va0.m7890e(6, this.f4358h);
                                                i7 = readInt;
                                                va0 m7887b = va0.m7887b(this.f4368r, this.f4358h);
                                                j5 = j6;
                                                va0 m7887b2 = va0.m7887b(this.f4369s, this.f4358h);
                                                hashMapArr[4].put(TAG_COMPRESSION, m7890e);
                                                hashMapArr[4].put(TAG_JPEG_INTERCHANGE_FORMAT, m7887b);
                                                hashMapArr[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, m7887b2);
                                            }
                                            j5 = j6;
                                            i7 = readInt;
                                        } else {
                                            j5 = j6;
                                            i7 = readInt;
                                            if (i14 == 10 && TAG_RW2_JPG_FROM_RAW.equals(wa0Var2.f28113b)) {
                                                this.f4370t = readInt2;
                                            }
                                        }
                                        long j7 = readInt2;
                                        wa0Var = wa0Var2;
                                        j2 = j;
                                        i9 = i2;
                                        if (j7 + j <= i9) {
                                            ta0Var.m7468a(j7);
                                            j6 = j5;
                                        } else {
                                            if (z3) {
                                                Log.d(str4, "Skip the tag entry since data offset is invalid: " + readInt2);
                                            }
                                            ta0Var.m7468a(j5);
                                            z2 = z3;
                                            hashSet2 = hashSet;
                                        }
                                    } else {
                                        i6 = readUnsignedShort3;
                                        j2 = j;
                                        i7 = readInt;
                                        i8 = i3;
                                        i9 = i2;
                                        wa0Var = wa0Var2;
                                    }
                                    Integer num = (Integer) f4342e0.get(Integer.valueOf(i8));
                                    if (z3) {
                                        StringBuilder sb = new StringBuilder("nextIfdType: ");
                                        sb.append(num);
                                        sb.append(" byteCount: ");
                                        j3 = j2;
                                        sb.append(j3);
                                        Log.d(str4, sb.toString());
                                    } else {
                                        j3 = j2;
                                    }
                                    if (num != null) {
                                        int i15 = i6;
                                        if (i15 != 3) {
                                            if (i15 != 4) {
                                                if (i15 != 8) {
                                                    if (i15 != 9 && i15 != 13) {
                                                        j4 = -1;
                                                    } else {
                                                        readUnsignedShort = ta0Var.readInt();
                                                    }
                                                } else {
                                                    readUnsignedShort = ta0Var.readShort();
                                                }
                                            } else {
                                                j4 = ta0Var.readInt() & 4294967295L;
                                            }
                                            if (!z3) {
                                                Log.d(str4, String.format("Offset: %d, tagName: %s", Long.valueOf(j4), wa0Var.f28113b));
                                            }
                                            if (j4 <= 0 && j4 < i9) {
                                                hashSet3 = hashSet;
                                                if (!hashSet3.contains(Integer.valueOf((int) j4))) {
                                                    ta0Var.m7468a(j4);
                                                    m1106G(ta0Var, num.intValue());
                                                } else if (z3) {
                                                    Log.d(str4, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j4 + ")");
                                                }
                                            } else {
                                                hashSet3 = hashSet;
                                                if (z3) {
                                                    Log.d(str4, "Skip jump into the IFD since its offset is invalid: " + j4);
                                                }
                                            }
                                            ta0Var.m7468a(j6);
                                            hashSet2 = hashSet3;
                                            z2 = z3;
                                            str2 = str4;
                                        } else {
                                            readUnsignedShort = ta0Var.readUnsignedShort();
                                        }
                                        j4 = readUnsignedShort;
                                        if (!z3) {
                                        }
                                        if (j4 <= 0) {
                                        }
                                        hashSet3 = hashSet;
                                        if (z3) {
                                        }
                                        ta0Var.m7468a(j6);
                                        hashSet2 = hashSet3;
                                        z2 = z3;
                                        str2 = str4;
                                    } else {
                                        hashSet2 = hashSet;
                                        int i16 = ta0Var.f26744d + this.f4366p;
                                        byte[] bArr = new byte[(int) j3];
                                        ta0Var.readFully(bArr);
                                        z2 = z3;
                                        str2 = str4;
                                        va0 va0Var = new va0(i16, bArr, i6, i7);
                                        hashMapArr[i].put(wa0Var.f28113b, va0Var);
                                        String str5 = wa0Var.f28113b;
                                        if (TAG_DNG_VERSION.equals(str5)) {
                                            this.f4354d = 3;
                                        }
                                        if (((TAG_MAKE.equals(str5) || TAG_MODEL.equals(str5)) && va0Var.m7894i(this.f4358h).contains("PENTAX")) || (TAG_COMPRESSION.equals(str5) && va0Var.m7893h(this.f4358h) == 65535)) {
                                            this.f4354d = 8;
                                        }
                                        if (ta0Var.f26744d != j6) {
                                            ta0Var.m7468a(j6);
                                        }
                                    }
                                    s2 = (short) (s + 1);
                                    hashSet4 = hashSet2;
                                    z3 = z2;
                                    i12 = i9;
                                    readShort = s3;
                                    str4 = str2;
                                    i10 = i;
                                }
                                str2 = str4;
                                s2 = (short) (s + 1);
                                hashSet4 = hashSet2;
                                z3 = z2;
                                i12 = i9;
                                readShort = s3;
                                str4 = str2;
                                i10 = i;
                            }
                        }
                    }
                    i3 = readUnsignedShort2;
                    if (z3) {
                        Log.d(str4, "Skip the tag entry since data format is invalid: " + readUnsignedShort3);
                    }
                    j = 0;
                    z = false;
                    if (z) {
                    }
                    str2 = str4;
                    s2 = (short) (s + 1);
                    hashSet4 = hashSet2;
                    z3 = z2;
                    i12 = i9;
                    readShort = s3;
                    str4 = str2;
                    i10 = i;
                }
                i3 = readUnsignedShort2;
                j = 0;
                z = false;
                if (z) {
                }
                str2 = str4;
                s2 = (short) (s + 1);
                hashSet4 = hashSet2;
                z3 = z2;
                i12 = i9;
                readShort = s3;
                str4 = str2;
                i10 = i;
            }
            HashSet hashSet5 = hashSet4;
            int i17 = i12;
            boolean z4 = z3;
            String str6 = str4;
            if (ta0Var.f26744d + 4 <= i17) {
                int readInt3 = ta0Var.readInt();
                if (z4) {
                    str = str6;
                    Log.d(str, String.format("nextIfdOffset: %d", Integer.valueOf(readInt3)));
                } else {
                    str = str6;
                }
                long j8 = readInt3;
                if (j8 > 0 && readInt3 < i17) {
                    if (!hashSet5.contains(Integer.valueOf(readInt3))) {
                        ta0Var.m7468a(j8);
                        if (hashMapArr[4].isEmpty()) {
                            m1106G(ta0Var, 4);
                            return;
                        } else {
                            if (hashMapArr[5].isEmpty()) {
                                m1106G(ta0Var, 5);
                                return;
                            }
                            return;
                        }
                    }
                    if (z4) {
                        Log.d(str, "Stop reading file since re-reading an IFD may cause an infinite loop: " + readInt3);
                        return;
                    }
                    return;
                }
                if (z4) {
                    Log.d(str, "Stop reading file since a wrong offset may cause an infinite loop: " + readInt3);
                }
            }
        }
    }

    /* renamed from: H */
    public final void m1107H(String str) {
        for (int i = 0; i < f4335X.length; i++) {
            this.f4356f[i].remove(str);
        }
    }

    /* renamed from: I */
    public final void m1108I(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        va0 va0Var;
        if (f4348x) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        ua0 ua0Var = new ua0(bufferedOutputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() == -1) {
            ua0Var.m7685a(-1);
            if (dataInputStream.readByte() == -40) {
                ua0Var.m7685a(-40);
                String attribute = getAttribute(TAG_XMP);
                HashMap[] hashMapArr = this.f4356f;
                if (attribute != null && this.f4373w) {
                    va0Var = (va0) hashMapArr[0].remove(TAG_XMP);
                } else {
                    va0Var = null;
                }
                ua0Var.m7685a(-1);
                ua0Var.m7685a(-31);
                m1115P(ua0Var);
                if (va0Var != null) {
                    hashMapArr[0].put(TAG_XMP, va0Var);
                }
                byte[] bArr = new byte[4096];
                while (dataInputStream.readByte() == -1) {
                    byte readByte = dataInputStream.readByte();
                    if (readByte != -39 && readByte != -38) {
                        if (readByte != -31) {
                            ua0Var.m7685a(-1);
                            ua0Var.m7685a(readByte);
                            int readUnsignedShort = dataInputStream.readUnsignedShort();
                            ua0Var.m7687c((short) readUnsignedShort);
                            int i = readUnsignedShort - 2;
                            if (i >= 0) {
                                while (i > 0) {
                                    int read = dataInputStream.read(bArr, 0, Math.min(i, 4096));
                                    if (read >= 0) {
                                        ua0Var.write(bArr, 0, read);
                                        i -= read;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        } else {
                            int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                            int i2 = readUnsignedShort2 - 2;
                            if (i2 >= 0) {
                                byte[] bArr2 = new byte[6];
                                if (i2 >= 6) {
                                    if (dataInputStream.read(bArr2) == 6) {
                                        if (Arrays.equals(bArr2, f4344g0)) {
                                            int i3 = readUnsignedShort2 - 8;
                                            if (dataInputStream.skipBytes(i3) != i3) {
                                                throw new IOException("Invalid length");
                                            }
                                        }
                                    } else {
                                        throw new IOException("Invalid exif");
                                    }
                                }
                                ua0Var.m7685a(-1);
                                ua0Var.m7685a(readByte);
                                ua0Var.m7687c((short) readUnsignedShort2);
                                if (i2 >= 6) {
                                    i2 = readUnsignedShort2 - 8;
                                    ua0Var.write(bArr2);
                                }
                                while (i2 > 0) {
                                    int read2 = dataInputStream.read(bArr, 0, Math.min(i2, 4096));
                                    if (read2 >= 0) {
                                        ua0Var.write(bArr, 0, read2);
                                        i2 -= read2;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    } else {
                        ua0Var.m7685a(-1);
                        ua0Var.m7685a(readByte);
                        m1098i(dataInputStream, ua0Var);
                        return;
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    /* renamed from: J */
    public final void m1109J(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        if (f4348x) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        ua0 ua0Var = new ua0(bufferedOutputStream, byteOrder);
        m1097h(dataInputStream, ua0Var, f4318G.length);
        if (this.f4366p == 0) {
            int readInt = dataInputStream.readInt();
            ua0Var.m7686b(readInt);
            m1097h(dataInputStream, ua0Var, readInt + 8);
        } else {
            m1097h(dataInputStream, ua0Var, (r2 - r7.length) - 8);
            dataInputStream.skipBytes(dataInputStream.readInt() + 8);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ua0 ua0Var2 = new ua0(byteArrayOutputStream2, byteOrder);
                m1115P(ua0Var2);
                byte[] byteArray = ((ByteArrayOutputStream) ua0Var2.f27164a).toByteArray();
                ua0Var.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                ua0Var.m7686b((int) crc32.getValue());
                m1093d(byteArrayOutputStream2);
                m1098i(dataInputStream, ua0Var);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                m1093d(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: K */
    public final void m1110K(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        int i;
        if (f4348x) {
            Log.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        ta0 ta0Var = new ta0(bufferedInputStream, byteOrder);
        ua0 ua0Var = new ua0(bufferedOutputStream, byteOrder);
        m1097h(ta0Var, ua0Var, f4322K.length);
        byte[] bArr = f4323L;
        ta0Var.skipBytes(bArr.length + 4);
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            ua0 ua0Var2 = new ua0(byteArrayOutputStream, byteOrder);
            if (this.f4366p != 0) {
                m1097h(ta0Var, ua0Var2, (r4 - ((r2.length + 4) + bArr.length)) - 8);
                ta0Var.skipBytes(4);
                ta0Var.skipBytes(ta0Var.readInt());
                m1115P(ua0Var2);
            } else {
                byte[] bArr2 = new byte[4];
                if (ta0Var.read(bArr2) == 4) {
                    byte[] bArr3 = f4325N;
                    boolean equals = Arrays.equals(bArr2, bArr3);
                    byte[] bArr4 = f4326O;
                    byte[] bArr5 = f4327P;
                    if (equals) {
                        int readInt = ta0Var.readInt();
                        if (readInt % 2 == 1) {
                            i = readInt + 1;
                        } else {
                            i = readInt;
                        }
                        byte[] bArr6 = new byte[i];
                        ta0Var.read(bArr6);
                        boolean z = false;
                        byte b = (byte) (bArr6[0] | 8);
                        bArr6[0] = b;
                        if (((b >> 1) & 1) == 1) {
                            z = true;
                        }
                        ua0Var2.write(bArr3);
                        ua0Var2.m7686b(readInt);
                        ua0Var2.write(bArr6);
                        if (z) {
                            m1099j(ta0Var, ua0Var2, f4328Q, null);
                            while (true) {
                                byte[] bArr7 = new byte[4];
                                bufferedInputStream.read(bArr7);
                                if (!Arrays.equals(bArr7, f4329R)) {
                                    break;
                                }
                                int readInt2 = ta0Var.readInt();
                                ua0Var2.write(bArr7);
                                ua0Var2.m7686b(readInt2);
                                if (readInt2 % 2 == 1) {
                                    readInt2++;
                                }
                                m1097h(ta0Var, ua0Var2, readInt2);
                            }
                            m1115P(ua0Var2);
                        } else {
                            m1099j(ta0Var, ua0Var2, bArr5, bArr4);
                            m1115P(ua0Var2);
                        }
                    } else if (Arrays.equals(bArr2, bArr5) || Arrays.equals(bArr2, bArr4)) {
                        throw new IOException("WebP files with only VP8 or VP8L chunks are currently not supported");
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunk type");
                }
            }
            m1098i(ta0Var, ua0Var2);
            ua0Var.m7686b(byteArrayOutputStream.size() + bArr.length);
            ua0Var.write(bArr);
            byteArrayOutputStream.writeTo(ua0Var);
            m1093d(byteArrayOutputStream);
        } catch (Exception e2) {
            e = e2;
            throw new IOException("Failed to save WebP file", e);
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            m1093d(byteArrayOutputStream2);
            throw th;
        }
    }

    /* renamed from: L */
    public final void m1111L(ta0 ta0Var) {
        va0 va0Var;
        int m7893h;
        HashMap hashMap = this.f4356f[4];
        va0 va0Var2 = (va0) hashMap.get(TAG_COMPRESSION);
        if (va0Var2 != null) {
            int m7893h2 = va0Var2.m7893h(this.f4358h);
            this.f4365o = m7893h2;
            if (m7893h2 != 1) {
                if (m7893h2 != 6) {
                    if (m7893h2 != 7) {
                        return;
                    }
                } else {
                    m1128w(ta0Var, hashMap);
                    return;
                }
            }
            va0 va0Var3 = (va0) hashMap.get(TAG_BITS_PER_SAMPLE);
            if (va0Var3 != null) {
                int[] iArr = (int[]) va0Var3.m7895j(this.f4358h);
                int[] iArr2 = BITS_PER_SAMPLE_RGB;
                if (Arrays.equals(iArr2, iArr) || (this.f4354d == 3 && (va0Var = (va0) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION)) != null && (((m7893h = va0Var.m7893h(this.f4358h)) == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (m7893h == 6 && Arrays.equals(iArr, iArr2))))) {
                    va0 va0Var4 = (va0) hashMap.get(TAG_STRIP_OFFSETS);
                    va0 va0Var5 = (va0) hashMap.get(TAG_STRIP_BYTE_COUNTS);
                    if (va0Var4 != null && va0Var5 != null) {
                        long[] m1096g = m1096g(va0Var4.m7895j(this.f4358h));
                        long[] m1096g2 = m1096g(va0Var5.m7895j(this.f4358h));
                        if (m1096g != null && m1096g.length != 0) {
                            if (m1096g2 != null && m1096g2.length != 0) {
                                if (m1096g.length != m1096g2.length) {
                                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                                    return;
                                }
                                long j = 0;
                                for (long j2 : m1096g2) {
                                    j += j2;
                                }
                                int i = (int) j;
                                byte[] bArr = new byte[i];
                                this.f4361k = true;
                                this.f4360j = true;
                                this.f4359i = true;
                                int i2 = 0;
                                int i3 = 0;
                                for (int i4 = 0; i4 < m1096g.length; i4++) {
                                    int i5 = (int) m1096g[i4];
                                    int i6 = (int) m1096g2[i4];
                                    if (i4 < m1096g.length - 1 && i5 + i6 != m1096g[i4 + 1]) {
                                        this.f4361k = false;
                                    }
                                    int i7 = i5 - i2;
                                    if (i7 < 0) {
                                        Log.d("ExifInterface", "Invalid strip offset value");
                                    }
                                    ta0Var.m7468a(i7);
                                    int i8 = i2 + i7;
                                    byte[] bArr2 = new byte[i6];
                                    ta0Var.read(bArr2);
                                    i2 = i8 + i6;
                                    System.arraycopy(bArr2, 0, bArr, i3, i6);
                                    i3 += i6;
                                }
                                this.f4364n = bArr;
                                if (this.f4361k) {
                                    this.f4362l = ((int) m1096g[0]) + this.f4366p;
                                    this.f4363m = i;
                                    return;
                                }
                                return;
                            }
                            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                            return;
                        }
                        Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                        return;
                    }
                    return;
                }
            }
            if (f4348x) {
                Log.d("ExifInterface", "Unsupported data type value");
                return;
            }
            return;
        }
        this.f4365o = 6;
        m1128w(ta0Var, hashMap);
    }

    /* renamed from: M */
    public final void m1112M(int i, int i2) {
        HashMap[] hashMapArr = this.f4356f;
        boolean isEmpty = hashMapArr[i].isEmpty();
        boolean z = f4348x;
        if (!isEmpty && !hashMapArr[i2].isEmpty()) {
            va0 va0Var = (va0) hashMapArr[i].get(TAG_IMAGE_LENGTH);
            va0 va0Var2 = (va0) hashMapArr[i].get(TAG_IMAGE_WIDTH);
            va0 va0Var3 = (va0) hashMapArr[i2].get(TAG_IMAGE_LENGTH);
            va0 va0Var4 = (va0) hashMapArr[i2].get(TAG_IMAGE_WIDTH);
            if (va0Var != null && va0Var2 != null) {
                if (va0Var3 != null && va0Var4 != null) {
                    int m7893h = va0Var.m7893h(this.f4358h);
                    int m7893h2 = va0Var2.m7893h(this.f4358h);
                    int m7893h3 = va0Var3.m7893h(this.f4358h);
                    int m7893h4 = va0Var4.m7893h(this.f4358h);
                    if (m7893h < m7893h3 && m7893h2 < m7893h4) {
                        HashMap hashMap = hashMapArr[i];
                        hashMapArr[i] = hashMapArr[i2];
                        hashMapArr[i2] = hashMap;
                        return;
                    }
                    return;
                }
                if (z) {
                    Log.d("ExifInterface", "Second image does not contain valid size information");
                    return;
                }
                return;
            }
            if (z) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (z) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    /* renamed from: N */
    public final void m1113N(ta0 ta0Var, int i) {
        va0 va0Var;
        va0 m7890e;
        va0 m7890e2;
        HashMap[] hashMapArr = this.f4356f;
        va0 va0Var2 = (va0) hashMapArr[i].get(TAG_DEFAULT_CROP_SIZE);
        va0 va0Var3 = (va0) hashMapArr[i].get(TAG_RW2_SENSOR_TOP_BORDER);
        va0 va0Var4 = (va0) hashMapArr[i].get(TAG_RW2_SENSOR_LEFT_BORDER);
        va0 va0Var5 = (va0) hashMapArr[i].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        va0 va0Var6 = (va0) hashMapArr[i].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (va0Var2 != null) {
            if (va0Var2.f27712a == 5) {
                xa0[] xa0VarArr = (xa0[]) va0Var2.m7895j(this.f4358h);
                if (xa0VarArr != null && xa0VarArr.length == 2) {
                    m7890e = va0.m7889d(new xa0[]{xa0VarArr[0]}, this.f4358h);
                    m7890e2 = va0.m7889d(new xa0[]{xa0VarArr[1]}, this.f4358h);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(xa0VarArr));
                    return;
                }
            } else {
                int[] iArr = (int[]) va0Var2.m7895j(this.f4358h);
                if (iArr != null && iArr.length == 2) {
                    m7890e = va0.m7890e(iArr[0], this.f4358h);
                    m7890e2 = va0.m7890e(iArr[1], this.f4358h);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
            }
            hashMapArr[i].put(TAG_IMAGE_WIDTH, m7890e);
            hashMapArr[i].put(TAG_IMAGE_LENGTH, m7890e2);
            return;
        }
        if (va0Var3 != null && va0Var4 != null && va0Var5 != null && va0Var6 != null) {
            int m7893h = va0Var3.m7893h(this.f4358h);
            int m7893h2 = va0Var5.m7893h(this.f4358h);
            int m7893h3 = va0Var6.m7893h(this.f4358h);
            int m7893h4 = va0Var4.m7893h(this.f4358h);
            if (m7893h2 > m7893h && m7893h3 > m7893h4) {
                va0 m7890e3 = va0.m7890e(m7893h2 - m7893h, this.f4358h);
                va0 m7890e4 = va0.m7890e(m7893h3 - m7893h4, this.f4358h);
                hashMapArr[i].put(TAG_IMAGE_LENGTH, m7890e3);
                hashMapArr[i].put(TAG_IMAGE_WIDTH, m7890e4);
                return;
            }
            return;
        }
        va0 va0Var7 = (va0) hashMapArr[i].get(TAG_IMAGE_LENGTH);
        va0 va0Var8 = (va0) hashMapArr[i].get(TAG_IMAGE_WIDTH);
        if ((va0Var7 == null || va0Var8 == null) && (va0Var = (va0) hashMapArr[i].get(TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
            m1119m(ta0Var, va0Var.m7893h(this.f4358h), i);
        }
    }

    /* renamed from: O */
    public final void m1114O() {
        m1112M(0, 5);
        m1112M(0, 4);
        m1112M(5, 4);
        HashMap[] hashMapArr = this.f4356f;
        va0 va0Var = (va0) hashMapArr[1].get(TAG_PIXEL_X_DIMENSION);
        va0 va0Var2 = (va0) hashMapArr[1].get(TAG_PIXEL_Y_DIMENSION);
        if (va0Var != null && va0Var2 != null) {
            hashMapArr[0].put(TAG_IMAGE_WIDTH, va0Var);
            hashMapArr[0].put(TAG_IMAGE_LENGTH, va0Var2);
        }
        if (hashMapArr[4].isEmpty() && m1130z(hashMapArr[5])) {
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        if (!m1130z(hashMapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
    }

    /* renamed from: P */
    public final void m1115P(ua0 ua0Var) {
        HashMap[] hashMapArr;
        char c;
        int[] iArr;
        short s;
        Iterator it;
        boolean z = true;
        wa0[][] wa0VarArr = f4335X;
        int[] iArr2 = new int[wa0VarArr.length];
        int[] iArr3 = new int[wa0VarArr.length];
        wa0[] wa0VarArr2 = f4336Y;
        for (wa0 wa0Var : wa0VarArr2) {
            m1107H(wa0Var.f28113b);
        }
        wa0 wa0Var2 = f4337Z;
        m1107H(wa0Var2.f28113b);
        wa0 wa0Var3 = f4338a0;
        m1107H(wa0Var3.f28113b);
        int i = 0;
        while (true) {
            int length = wa0VarArr.length;
            hashMapArr = this.f4356f;
            if (i >= length) {
                break;
            }
            for (Object obj : hashMapArr[i].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    hashMapArr[i].remove(entry.getKey());
                }
            }
            i++;
        }
        if (!hashMapArr[1].isEmpty()) {
            c = 0;
            hashMapArr[0].put(wa0VarArr2[1].f28113b, va0.m7887b(0L, this.f4358h));
        } else {
            c = 0;
        }
        if (!hashMapArr[2].isEmpty()) {
            hashMapArr[c].put(wa0VarArr2[2].f28113b, va0.m7887b(0L, this.f4358h));
        }
        if (!hashMapArr[3].isEmpty()) {
            hashMapArr[1].put(wa0VarArr2[3].f28113b, va0.m7887b(0L, this.f4358h));
        }
        boolean z2 = this.f4359i;
        String str = wa0Var2.f28113b;
        if (z2) {
            hashMapArr[4].put(str, va0.m7887b(0L, this.f4358h));
            hashMapArr[4].put(wa0Var3.f28113b, va0.m7887b(this.f4363m, this.f4358h));
        }
        int i2 = 0;
        while (true) {
            int length2 = wa0VarArr.length;
            iArr = f4332U;
            if (i2 >= length2) {
                break;
            }
            Iterator it2 = hashMapArr[i2].entrySet().iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                va0 va0Var = (va0) ((Map.Entry) it2.next()).getValue();
                va0Var.getClass();
                int i4 = iArr[va0Var.f27712a] * va0Var.f27713b;
                if (i4 > 4) {
                    i3 += i4;
                }
            }
            iArr3[i2] = iArr3[i2] + i3;
            i2++;
        }
        int i5 = 8;
        for (int i6 = 0; i6 < wa0VarArr.length; i6++) {
            if (!hashMapArr[i6].isEmpty()) {
                iArr2[i6] = i5;
                i5 += (hashMapArr[i6].size() * 12) + 6 + iArr3[i6];
            }
        }
        if (this.f4359i) {
            hashMapArr[4].put(str, va0.m7887b(i5, this.f4358h));
            this.f4362l = this.f4366p + i5;
            i5 += this.f4363m;
        }
        if (this.f4354d == 4) {
            i5 += 8;
        }
        if (f4348x) {
            int i7 = 0;
            while (i7 < wa0VarArr.length) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i7), Integer.valueOf(iArr2[i7]), Integer.valueOf(hashMapArr[i7].size()), Integer.valueOf(iArr3[i7]), Integer.valueOf(i5)));
                i7++;
                z = true;
            }
        }
        boolean z3 = z;
        if (!hashMapArr[z3 ? 1 : 0].isEmpty()) {
            hashMapArr[0].put(wa0VarArr2[z3 ? 1 : 0].f28113b, va0.m7887b(iArr2[z3 ? 1 : 0], this.f4358h));
        }
        if (!hashMapArr[2].isEmpty()) {
            hashMapArr[0].put(wa0VarArr2[2].f28113b, va0.m7887b(iArr2[2], this.f4358h));
        }
        if (!hashMapArr[3].isEmpty()) {
            hashMapArr[1].put(wa0VarArr2[3].f28113b, va0.m7887b(iArr2[3], this.f4358h));
        }
        int i8 = this.f4354d;
        if (i8 != 4) {
            if (i8 != 13) {
                if (i8 == 14) {
                    ua0Var.write(f4324M);
                    ua0Var.m7686b(i5);
                }
            } else {
                ua0Var.m7686b(i5);
                ua0Var.write(f4319H);
            }
        } else {
            ua0Var.m7687c((short) i5);
            ua0Var.write(f4344g0);
        }
        if (this.f4358h == ByteOrder.BIG_ENDIAN) {
            s = 19789;
        } else {
            s = 18761;
        }
        ua0Var.m7687c(s);
        ua0Var.f27165b = this.f4358h;
        ua0Var.m7687c((short) 42);
        ua0Var.m7686b((int) 8);
        for (int i9 = 0; i9 < wa0VarArr.length; i9++) {
            if (!hashMapArr[i9].isEmpty()) {
                ua0Var.m7687c((short) hashMapArr[i9].size());
                int size = (hashMapArr[i9].size() * 12) + iArr2[i9] + 2 + 4;
                Iterator it3 = hashMapArr[i9].entrySet().iterator();
                while (it3.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it3.next();
                    int i10 = ((wa0) f4340c0[i9].get(entry2.getKey())).f28112a;
                    va0 va0Var2 = (va0) entry2.getValue();
                    va0Var2.getClass();
                    int i11 = va0Var2.f27712a;
                    int i12 = iArr[i11];
                    int i13 = va0Var2.f27713b;
                    int i14 = i12 * i13;
                    ua0Var.m7687c((short) i10);
                    ua0Var.m7687c((short) i11);
                    ua0Var.m7686b(i13);
                    if (i14 > 4) {
                        it = it3;
                        ua0Var.m7686b(size);
                        size += i14;
                    } else {
                        it = it3;
                        ua0Var.write(va0Var2.f27715d);
                        if (i14 < 4) {
                            while (i14 < 4) {
                                ua0Var.m7685a(0);
                                i14++;
                            }
                        }
                    }
                    it3 = it;
                }
                if (i9 == 0 && !hashMapArr[4].isEmpty()) {
                    ua0Var.m7686b(iArr2[4]);
                } else {
                    ua0Var.m7686b((int) 0);
                }
                Iterator it4 = hashMapArr[i9].entrySet().iterator();
                while (it4.hasNext()) {
                    byte[] bArr = ((va0) ((Map.Entry) it4.next()).getValue()).f27715d;
                    if (bArr.length > 4) {
                        ua0Var.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.f4359i) {
            ua0Var.write(getThumbnailBytes());
        }
        if (this.f4354d == 14 && i5 % 2 == 1) {
            ua0Var.m7685a(0);
        }
        ua0Var.f27165b = ByteOrder.BIG_ENDIAN;
    }

    /* renamed from: a */
    public final void m1116a() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        HashMap[] hashMapArr = this.f4356f;
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            hashMapArr[0].put(TAG_DATETIME, va0.m7886a(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            hashMapArr[0].put(TAG_IMAGE_WIDTH, va0.m7887b(0L, this.f4358h));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            hashMapArr[0].put(TAG_IMAGE_LENGTH, va0.m7887b(0L, this.f4358h));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            hashMapArr[0].put(TAG_ORIENTATION, va0.m7887b(0L, this.f4358h));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            hashMapArr[1].put(TAG_LIGHT_SOURCE, va0.m7887b(0L, this.f4358h));
        }
    }

    public void flipHorizontally() {
        int i = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i = 2;
                break;
            case 2:
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i));
    }

    public void flipVertically() {
        int i = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i = 4;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                break;
            case 5:
                i = 8;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                i = 5;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i));
    }

    public double getAltitude(double d) {
        double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int i = -1;
        int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble >= 0.0d && attributeInt >= 0) {
            if (attributeInt != 1) {
                i = 1;
            }
            return attributeDouble * i;
        }
        return d;
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        if (str != null) {
            va0 m1117k = m1117k(str);
            if (m1117k != null) {
                if (!f4341d0.contains(str)) {
                    return m1117k.m7894i(this.f4358h);
                }
                if (str.equals(TAG_GPS_TIMESTAMP)) {
                    int i = m1117k.f27712a;
                    if (i != 5 && i != 10) {
                        Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i);
                        return null;
                    }
                    xa0[] xa0VarArr = (xa0[]) m1117k.m7895j(this.f4358h);
                    if (xa0VarArr != null && xa0VarArr.length == 3) {
                        xa0 xa0Var = xa0VarArr[0];
                        Integer valueOf = Integer.valueOf((int) (((float) xa0Var.f28485a) / ((float) xa0Var.f28486b)));
                        xa0 xa0Var2 = xa0VarArr[1];
                        Integer valueOf2 = Integer.valueOf((int) (((float) xa0Var2.f28485a) / ((float) xa0Var2.f28486b)));
                        xa0 xa0Var3 = xa0VarArr[2];
                        return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (((float) xa0Var3.f28485a) / ((float) xa0Var3.f28486b))));
                    }
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(xa0VarArr));
                    return null;
                }
                try {
                    return Double.toString(m1117k.m7892g(this.f4358h));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @Nullable
    public byte[] getAttributeBytes(@NonNull String str) {
        if (str != null) {
            va0 m1117k = m1117k(str);
            if (m1117k != null) {
                return m1117k.f27715d;
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public double getAttributeDouble(@NonNull String str, double d) {
        if (str != null) {
            va0 m1117k = m1117k(str);
            if (m1117k == null) {
                return d;
            }
            try {
                return m1117k.m7892g(this.f4358h);
            } catch (NumberFormatException unused) {
                return d;
            }
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public int getAttributeInt(@NonNull String str, int i) {
        if (str != null) {
            va0 m1117k = m1117k(str);
            if (m1117k == null) {
                return i;
            }
            try {
                return m1117k.m7893h(this.f4358h);
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @Nullable
    public long[] getAttributeRange(@NonNull String str) {
        if (str != null) {
            if (!this.f4372v) {
                va0 m1117k = m1117k(str);
                if (m1117k != null) {
                    return new long[]{m1117k.f27714c, m1117k.f27715d.length};
                }
                return null;
            }
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getDateTime() {
        return m1089B(getAttribute(TAG_DATETIME), getAttribute(TAG_SUBSEC_TIME));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getDateTimeDigitized() {
        return m1089B(getAttribute(TAG_DATETIME_DIGITIZED), getAttribute(TAG_SUBSEC_TIME_DIGITIZED));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getDateTimeOriginal() {
        return m1089B(getAttribute(TAG_DATETIME_ORIGINAL), getAttribute(TAG_SUBSEC_TIME_ORIGINAL));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getGpsDateTime() {
        String attribute = getAttribute(TAG_GPS_DATESTAMP);
        String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
        if (attribute != null && attribute2 != null) {
            Pattern pattern = f4346i0;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                try {
                    Date parse = f4330S.parse(attribute + ' ' + attribute2, new ParsePosition(0));
                    if (parse == null) {
                        return -1L;
                    }
                    return parse.getTime();
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return -1L;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] getThumbnail() {
        int i = this.f4365o;
        if (i != 6 && i != 7) {
            return null;
        }
        return getThumbnailBytes();
    }

    @Nullable
    public Bitmap getThumbnailBitmap() {
        if (!this.f4359i) {
            return null;
        }
        if (this.f4364n == null) {
            this.f4364n = getThumbnailBytes();
        }
        int i = this.f4365o;
        if (i != 6 && i != 7) {
            if (i == 1) {
                int length = this.f4364n.length / 3;
                int[] iArr = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    byte[] bArr = this.f4364n;
                    int i3 = i2 * 3;
                    iArr[i2] = (bArr[i3] << Ascii.DLE) + (bArr[i3 + 1] << 8) + bArr[i3 + 2];
                }
                HashMap[] hashMapArr = this.f4356f;
                va0 va0Var = (va0) hashMapArr[4].get(TAG_IMAGE_LENGTH);
                va0 va0Var2 = (va0) hashMapArr[4].get(TAG_IMAGE_WIDTH);
                if (va0Var != null && va0Var2 != null) {
                    return Bitmap.createBitmap(iArr, va0Var2.m7893h(this.f4358h), va0Var.m7893h(this.f4358h), Bitmap.Config.ARGB_8888);
                }
            }
            return null;
        }
        return BitmapFactory.decodeByteArray(this.f4364n, 0, this.f4363m);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069 A[Catch: all -> 0x0090, Exception -> 0x0092, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0090, blocks: (B:18:0x0069, B:21:0x0079, B:23:0x0085, B:28:0x0094, B:29:0x0099, B:30:0x009a, B:31:0x009f, B:32:0x00a0, B:33:0x00a5, B:35:0x00a6), top: B:6:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a0 A[Catch: all -> 0x0090, Exception -> 0x0092, TryCatch #1 {all -> 0x0090, blocks: (B:18:0x0069, B:21:0x0079, B:23:0x0085, B:28:0x0094, B:29:0x0099, B:30:0x009a, B:31:0x009f, B:32:0x00a0, B:33:0x00a5, B:35:0x00a6), top: B:6:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b9  */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable, java.io.InputStream] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getThumbnailBytes() {
        FileDescriptor fileDescriptor;
        Exception e;
        FileDescriptor fileDescriptor2;
        FileInputStream fileInputStream;
        Closeable closeable = null;
        if (!this.f4359i) {
            return null;
        }
        ?? r1 = this.f4364n;
        try {
            if (r1 != 0) {
                return r1;
            }
            try {
                r1 = this.f4353c;
                try {
                    if (r1 != 0) {
                        try {
                            if (r1.markSupported()) {
                                r1.reset();
                                fileInputStream = r1;
                            } else {
                                Log.d("ExifInterface", "Cannot read thumbnail from inputstream without mark/reset support");
                                m1093d(r1);
                                return null;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            fileDescriptor2 = null;
                            Log.d("ExifInterface", "Encountered exception while getting thumbnail", e);
                            m1093d(r1);
                            if (fileDescriptor2 != null) {
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            fileDescriptor = null;
                            closeable = r1;
                            m1093d(closeable);
                            if (fileDescriptor != null) {
                            }
                            throw th;
                        }
                    } else if (this.f4351a != null) {
                        fileInputStream = new FileInputStream(this.f4351a);
                    } else {
                        FileDescriptor fileDescriptor3 = this.f4352b;
                        if (fileDescriptor3 != null) {
                            FileDescriptor dup = Os.dup(fileDescriptor3);
                            try {
                                Os.lseek(dup, 0L, OsConstants.SEEK_SET);
                                fileDescriptor2 = dup;
                                r1 = new FileInputStream(dup);
                            } catch (Exception e3) {
                                e = e3;
                                fileDescriptor2 = dup;
                                r1 = 0;
                                Log.d("ExifInterface", "Encountered exception while getting thumbnail", e);
                                m1093d(r1);
                                if (fileDescriptor2 != null) {
                                }
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileDescriptor = dup;
                                m1093d(closeable);
                                if (fileDescriptor != null) {
                                    m1092c(fileDescriptor);
                                }
                                throw th;
                            }
                        } else {
                            r1 = 0;
                            fileDescriptor2 = null;
                        }
                        if (r1 == 0) {
                            if (r1.skip(this.f4362l) == this.f4362l) {
                                byte[] bArr = new byte[this.f4363m];
                                if (r1.read(bArr) == this.f4363m) {
                                    this.f4364n = bArr;
                                    m1093d(r1);
                                    if (fileDescriptor2 != null) {
                                        m1092c(fileDescriptor2);
                                    }
                                    return bArr;
                                }
                                throw new IOException("Corrupted image");
                            }
                            throw new IOException("Corrupted image");
                        }
                        throw new FileNotFoundException();
                    }
                    if (r1 == 0) {
                    }
                } catch (Exception e4) {
                    e = e4;
                    Log.d("ExifInterface", "Encountered exception while getting thumbnail", e);
                    m1093d(r1);
                    if (fileDescriptor2 != null) {
                        m1092c(fileDescriptor2);
                    }
                    return null;
                }
                fileDescriptor2 = null;
                r1 = fileInputStream;
            } catch (Exception e5) {
                r1 = 0;
                e = e5;
                fileDescriptor2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileDescriptor = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Nullable
    public long[] getThumbnailRange() {
        if (!this.f4372v) {
            if (!this.f4359i) {
                return null;
            }
            if (this.f4360j && !this.f4361k) {
                return null;
            }
            return new long[]{this.f4362l, this.f4363m};
        }
        throw new IllegalStateException("The underlying file has been modified since being parsed");
    }

    public boolean hasAttribute(@NonNull String str) {
        if (m1117k(str) != null) {
            return true;
        }
        return false;
    }

    public boolean hasThumbnail() {
        return this.f4359i;
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        if (attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5) {
            return true;
        }
        return false;
    }

    public boolean isThumbnailCompressed() {
        if (!this.f4359i) {
            return false;
        }
        int i = this.f4365o;
        if (i != 6 && i != 7) {
            return false;
        }
        return true;
    }

    /* renamed from: k */
    public final va0 m1117k(String str) {
        if (str != null) {
            if (TAG_ISO_SPEED_RATINGS.equals(str)) {
                if (f4348x) {
                    Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = TAG_PHOTOGRAPHIC_SENSITIVITY;
            }
            for (int i = 0; i < f4335X.length; i++) {
                va0 va0Var = (va0) this.f4356f[i].get(str);
                if (va0Var != null) {
                    return va0Var;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    /* renamed from: l */
    public final void m1118l(ta0 ta0Var) {
        String str;
        String str2;
        String str3;
        int i;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(new sa0(ta0Var));
            String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            if ("yes".equals(extractMetadata3)) {
                str = mediaMetadataRetriever.extractMetadata(29);
                str2 = mediaMetadataRetriever.extractMetadata(30);
                str3 = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(extractMetadata4)) {
                str = mediaMetadataRetriever.extractMetadata(18);
                str2 = mediaMetadataRetriever.extractMetadata(19);
                str3 = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            HashMap[] hashMapArr = this.f4356f;
            if (str != null) {
                hashMapArr[0].put(TAG_IMAGE_WIDTH, va0.m7890e(Integer.parseInt(str), this.f4358h));
            }
            if (str2 != null) {
                hashMapArr[0].put(TAG_IMAGE_LENGTH, va0.m7890e(Integer.parseInt(str2), this.f4358h));
            }
            if (str3 != null) {
                int parseInt = Integer.parseInt(str3);
                if (parseInt != 90) {
                    if (parseInt != 180) {
                        if (parseInt != 270) {
                            i = 1;
                        } else {
                            i = 8;
                        }
                    } else {
                        i = 3;
                    }
                } else {
                    i = 6;
                }
                hashMapArr[0].put(TAG_ORIENTATION, va0.m7890e(i, this.f4358h));
            }
            if (extractMetadata != null && extractMetadata2 != null) {
                int parseInt2 = Integer.parseInt(extractMetadata);
                int parseInt3 = Integer.parseInt(extractMetadata2);
                if (parseInt3 > 6) {
                    ta0Var.m7468a(parseInt2);
                    byte[] bArr = new byte[6];
                    if (ta0Var.read(bArr) == 6) {
                        int i2 = parseInt2 + 6;
                        int i3 = parseInt3 - 6;
                        if (Arrays.equals(bArr, f4344g0)) {
                            byte[] bArr2 = new byte[i3];
                            if (ta0Var.read(bArr2) == i3) {
                                this.f4366p = i2;
                                m1105F(0, bArr2);
                            } else {
                                throw new IOException("Can't read exif");
                            }
                        } else {
                            throw new IOException("Invalid identifier");
                        }
                    } else {
                        throw new IOException("Can't read identifier");
                    }
                } else {
                    throw new IOException("Invalid exif length");
                }
            }
            if (f4348x) {
                Log.d("ExifInterface", "Heif meta: " + str + "x" + str2 + ", rotation " + str3);
            }
            mediaMetadataRetriever.release();
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x01a0, code lost:
    
        r23.f26742b = r22.f4358h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a4, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x00ad. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b2 A[FALL_THROUGH] */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1119m(ta0 ta0Var, int i, int i2) {
        boolean z = f4348x;
        if (z) {
            Log.d("ExifInterface", "getJpegAttributes starting with: " + ta0Var);
        }
        ta0Var.f26742b = ByteOrder.BIG_ENDIAN;
        ta0Var.m7468a(i);
        byte readByte = ta0Var.readByte();
        byte b = -1;
        if (readByte == -1) {
            if (ta0Var.readByte() == -40) {
                int i3 = i + 2;
                while (true) {
                    byte readByte2 = ta0Var.readByte();
                    if (readByte2 == b) {
                        byte readByte3 = ta0Var.readByte();
                        if (z) {
                            Log.d("ExifInterface", "Found JPEG segment indicator: " + Integer.toHexString(readByte3 & 255));
                        }
                        if (readByte3 != -39 && readByte3 != -38) {
                            int readUnsignedShort = ta0Var.readUnsignedShort();
                            int i4 = readUnsignedShort - 2;
                            int i5 = i3 + 4;
                            if (z) {
                                Log.d("ExifInterface", "JPEG segment: " + Integer.toHexString(readByte3 & 255) + " (length: " + readUnsignedShort + ")");
                            }
                            if (i4 >= 0) {
                                HashMap[] hashMapArr = this.f4356f;
                                if (readByte3 != -31) {
                                    if (readByte3 != -2) {
                                        switch (readByte3) {
                                            default:
                                                switch (readByte3) {
                                                    default:
                                                        switch (readByte3) {
                                                            default:
                                                                switch (readByte3) {
                                                                }
                                                            case -55:
                                                            case -54:
                                                            case -53:
                                                                if (ta0Var.skipBytes(1) == 1) {
                                                                    hashMapArr[i2].put(TAG_IMAGE_LENGTH, va0.m7887b(ta0Var.readUnsignedShort(), this.f4358h));
                                                                    hashMapArr[i2].put(TAG_IMAGE_WIDTH, va0.m7887b(ta0Var.readUnsignedShort(), this.f4358h));
                                                                    i4 = readUnsignedShort - 7;
                                                                    break;
                                                                } else {
                                                                    throw new IOException("Invalid SOFx");
                                                                }
                                                        }
                                                    case -59:
                                                    case -58:
                                                    case -57:
                                                        break;
                                                }
                                            case -64:
                                            case -63:
                                            case -62:
                                            case -61:
                                                break;
                                        }
                                        if (i4 < 0) {
                                            if (ta0Var.skipBytes(i4) == i4) {
                                                i3 = i5 + i4;
                                                b = -1;
                                            } else {
                                                throw new IOException("Invalid JPEG segment");
                                            }
                                        } else {
                                            throw new IOException("Invalid length");
                                        }
                                    } else {
                                        byte[] bArr = new byte[i4];
                                        if (ta0Var.read(bArr) == i4) {
                                            if (getAttribute(TAG_USER_COMMENT) == null) {
                                                hashMapArr[1].put(TAG_USER_COMMENT, va0.m7886a(new String(bArr, f4343f0)));
                                            }
                                        } else {
                                            throw new IOException("Invalid exif");
                                        }
                                    }
                                } else {
                                    byte[] bArr2 = new byte[i4];
                                    ta0Var.readFully(bArr2);
                                    int i6 = i5 + i4;
                                    byte[] bArr3 = f4344g0;
                                    if (bArr3 != null && i4 >= bArr3.length) {
                                        for (int i7 = 0; i7 < bArr3.length; i7++) {
                                            if (bArr2[i7] == bArr3[i7]) {
                                            }
                                        }
                                        int length = i5 + bArr3.length;
                                        byte[] copyOfRange = Arrays.copyOfRange(bArr2, bArr3.length, i4);
                                        this.f4366p = length;
                                        m1105F(i2, copyOfRange);
                                        i5 = i6;
                                    }
                                    byte[] bArr4 = f4345h0;
                                    if (bArr4 != null && i4 >= bArr4.length) {
                                        int i8 = 0;
                                        while (true) {
                                            if (i8 < bArr4.length) {
                                                if (bArr2[i8] == bArr4[i8]) {
                                                    i8++;
                                                }
                                            } else {
                                                int length2 = i5 + bArr4.length;
                                                byte[] copyOfRange2 = Arrays.copyOfRange(bArr2, bArr4.length, i4);
                                                if (getAttribute(TAG_XMP) == null) {
                                                    hashMapArr[0].put(TAG_XMP, new va0(length2, copyOfRange2, 1, copyOfRange2.length));
                                                    this.f4373w = true;
                                                }
                                            }
                                        }
                                    }
                                    i5 = i6;
                                }
                                i4 = 0;
                                if (i4 < 0) {
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    } else {
                        throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
                    }
                }
            } else {
                throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
            }
        } else {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x00bf, code lost:
    
        if (r8 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0155, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0132  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m1120n(BufferedInputStream bufferedInputStream) {
        InputStream inputStream;
        ta0 ta0Var;
        ta0 ta0Var2;
        ta0 ta0Var3;
        boolean z;
        ta0 ta0Var4;
        ta0 ta0Var5;
        boolean z2;
        boolean z3;
        boolean z4;
        ta0 ta0Var6;
        long j;
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr2 = f4312A;
            if (i >= bArr2.length) {
                return 4;
            }
            if (bArr[i] != bArr2[i]) {
                byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
                for (int i2 = 0; i2 < bytes.length; i2++) {
                    byte b = bArr[i2];
                    ?? r8 = bytes[i2];
                    try {
                        if (b != r8) {
                            try {
                                ta0Var = new ta0(bArr);
                                try {
                                    long readInt = ta0Var.readInt();
                                    byte[] bArr3 = new byte[4];
                                    ta0Var.read(bArr3);
                                    if (Arrays.equals(bArr3, f4313B)) {
                                        if (readInt == 1) {
                                            readInt = ta0Var.readLong();
                                            j = 16;
                                            if (readInt < 16) {
                                            }
                                        } else {
                                            j = 8;
                                        }
                                        long j2 = 5000;
                                        if (readInt > j2) {
                                            readInt = j2;
                                        }
                                        long j3 = readInt - j;
                                        if (j3 >= 8) {
                                            byte[] bArr4 = new byte[4];
                                            boolean z5 = false;
                                            boolean z6 = false;
                                            for (long j4 = 0; j4 < j3 / 4 && ta0Var.read(bArr4) == 4; j4++) {
                                                if (j4 != 1) {
                                                    if (Arrays.equals(bArr4, f4314C)) {
                                                        z5 = true;
                                                    } else if (Arrays.equals(bArr4, f4315D)) {
                                                        z6 = true;
                                                    }
                                                    if (z5 && z6) {
                                                        ta0Var.close();
                                                        return 12;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    if (f4348x) {
                                        Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                ta0Var = null;
                            } catch (Throwable th) {
                                th = th;
                                inputStream = null;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                            ta0Var.close();
                            try {
                                ta0Var3 = new ta0(bArr);
                                try {
                                    ByteOrder m1090E = m1090E(ta0Var3);
                                    this.f4358h = m1090E;
                                    ta0Var3.f26742b = m1090E;
                                    short readShort = ta0Var3.readShort();
                                    if (readShort != 20306 && readShort != 21330) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    ta0Var3.close();
                                } catch (Exception unused) {
                                    if (ta0Var3 != null) {
                                        ta0Var3.close();
                                    }
                                    z = false;
                                    if (!z) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    ta0Var2 = ta0Var3;
                                    if (ta0Var2 != null) {
                                        ta0Var2.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception unused2) {
                                ta0Var3 = null;
                            } catch (Throwable th3) {
                                th = th3;
                                ta0Var2 = null;
                            }
                            if (!z) {
                                return 7;
                            }
                            try {
                                ta0Var6 = new ta0(bArr);
                            } catch (Exception unused3) {
                                ta0Var5 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                ta0Var4 = null;
                            }
                            try {
                                ByteOrder m1090E2 = m1090E(ta0Var6);
                                this.f4358h = m1090E2;
                                ta0Var6.f26742b = m1090E2;
                                if (ta0Var6.readShort() == 85) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                ta0Var6.close();
                            } catch (Exception unused4) {
                                ta0Var5 = ta0Var6;
                                if (ta0Var5 != null) {
                                    ta0Var5.close();
                                }
                                z2 = false;
                                if (!z2) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                ta0Var4 = ta0Var6;
                                if (ta0Var4 != null) {
                                    ta0Var4.close();
                                }
                                throw th;
                            }
                            if (!z2) {
                                return 10;
                            }
                            int i3 = 0;
                            while (true) {
                                byte[] bArr5 = f4318G;
                                if (i3 < bArr5.length) {
                                    if (bArr[i3] != bArr5[i3]) {
                                        z3 = false;
                                        break;
                                    }
                                    i3++;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (z3) {
                                return 13;
                            }
                            int i4 = 0;
                            while (true) {
                                byte[] bArr6 = f4322K;
                                if (i4 < bArr6.length) {
                                    if (bArr[i4] != bArr6[i4]) {
                                        break;
                                    }
                                    i4++;
                                } else {
                                    int i5 = 0;
                                    while (true) {
                                        byte[] bArr7 = f4323L;
                                        if (i5 < bArr7.length) {
                                            if (bArr[bArr6.length + i5 + 4] != bArr7[i5]) {
                                                break;
                                            }
                                            i5++;
                                        } else {
                                            z4 = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z4) {
                                return 0;
                            }
                            return 14;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = r8;
                    }
                }
                return 9;
            }
            i++;
        }
    }

    /* renamed from: o */
    public final void m1121o(ta0 ta0Var) {
        int i;
        int i2;
        m1124r(ta0Var);
        HashMap[] hashMapArr = this.f4356f;
        va0 va0Var = (va0) hashMapArr[1].get(TAG_MAKER_NOTE);
        if (va0Var != null) {
            ta0 ta0Var2 = new ta0(va0Var.f27715d);
            ta0Var2.f26742b = this.f4358h;
            byte[] bArr = f4316E;
            byte[] bArr2 = new byte[bArr.length];
            ta0Var2.readFully(bArr2);
            ta0Var2.m7468a(0L);
            byte[] bArr3 = f4317F;
            byte[] bArr4 = new byte[bArr3.length];
            ta0Var2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                ta0Var2.m7468a(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                ta0Var2.m7468a(12L);
            }
            m1106G(ta0Var2, 6);
            va0 va0Var2 = (va0) hashMapArr[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            va0 va0Var3 = (va0) hashMapArr[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (va0Var2 != null && va0Var3 != null) {
                hashMapArr[5].put(TAG_JPEG_INTERCHANGE_FORMAT, va0Var2);
                hashMapArr[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, va0Var3);
            }
            va0 va0Var4 = (va0) hashMapArr[8].get(TAG_ORF_ASPECT_FRAME);
            if (va0Var4 != null) {
                int[] iArr = (int[]) va0Var4.m7895j(this.f4358h);
                if (iArr != null && iArr.length == 4) {
                    int i3 = iArr[2];
                    int i4 = iArr[0];
                    if (i3 > i4 && (i = iArr[3]) > (i2 = iArr[1])) {
                        int i5 = (i3 - i4) + 1;
                        int i6 = (i - i2) + 1;
                        if (i5 < i6) {
                            int i7 = i5 + i6;
                            i6 = i7 - i6;
                            i5 = i7 - i6;
                        }
                        va0 m7890e = va0.m7890e(i5, this.f4358h);
                        va0 m7890e2 = va0.m7890e(i6, this.f4358h);
                        hashMapArr[0].put(TAG_IMAGE_WIDTH, m7890e);
                        hashMapArr[0].put(TAG_IMAGE_LENGTH, m7890e2);
                        return;
                    }
                    return;
                }
                Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
            }
        }
    }

    /* renamed from: p */
    public final void m1122p(ta0 ta0Var) {
        if (f4348x) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + ta0Var);
        }
        ta0Var.f26742b = ByteOrder.BIG_ENDIAN;
        byte[] bArr = f4318G;
        ta0Var.skipBytes(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = ta0Var.readInt();
                byte[] bArr2 = new byte[4];
                if (ta0Var.read(bArr2) == 4) {
                    int i = length + 8;
                    if (i == 16 && !Arrays.equals(bArr2, f4320I)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                    if (!Arrays.equals(bArr2, f4321J)) {
                        if (Arrays.equals(bArr2, f4319H)) {
                            byte[] bArr3 = new byte[readInt];
                            if (ta0Var.read(bArr3) == readInt) {
                                int readInt2 = ta0Var.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f4366p = i;
                                    m1105F(0, bArr3);
                                    m1114O();
                                    return;
                                } else {
                                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                                }
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + m1091b(bArr2));
                        }
                        int i2 = readInt + 4;
                        ta0Var.skipBytes(i2);
                        length = i + i2;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    /* renamed from: q */
    public final void m1123q(ta0 ta0Var) {
        ta0Var.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        ta0Var.read(bArr);
        ta0Var.skipBytes(4);
        ta0Var.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        m1119m(ta0Var, i, 5);
        ta0Var.m7468a(i2);
        ta0Var.f26742b = ByteOrder.BIG_ENDIAN;
        int readInt = ta0Var.readInt();
        boolean z = f4348x;
        if (z) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = ta0Var.readUnsignedShort();
            int readUnsignedShort2 = ta0Var.readUnsignedShort();
            if (readUnsignedShort == f4334W.f28112a) {
                short readShort = ta0Var.readShort();
                short readShort2 = ta0Var.readShort();
                va0 m7890e = va0.m7890e(readShort, this.f4358h);
                va0 m7890e2 = va0.m7890e(readShort2, this.f4358h);
                HashMap[] hashMapArr = this.f4356f;
                hashMapArr[0].put(TAG_IMAGE_LENGTH, m7890e);
                hashMapArr[0].put(TAG_IMAGE_WIDTH, m7890e2);
                if (z) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            ta0Var.skipBytes(readUnsignedShort2);
        }
    }

    /* renamed from: r */
    public final void m1124r(ta0 ta0Var) {
        m1103C(ta0Var, ta0Var.f26741a.available());
        m1106G(ta0Var, 0);
        m1113N(ta0Var, 0);
        m1113N(ta0Var, 5);
        m1113N(ta0Var, 4);
        m1114O();
        if (this.f4354d == 8) {
            HashMap[] hashMapArr = this.f4356f;
            va0 va0Var = (va0) hashMapArr[1].get(TAG_MAKER_NOTE);
            if (va0Var != null) {
                ta0 ta0Var2 = new ta0(va0Var.f27715d);
                ta0Var2.f26742b = this.f4358h;
                ta0Var2.m7468a(6L);
                m1106G(ta0Var2, 9);
                va0 va0Var2 = (va0) hashMapArr[9].get(TAG_COLOR_SPACE);
                if (va0Var2 != null) {
                    hashMapArr[1].put(TAG_COLOR_SPACE, va0Var2);
                }
            }
        }
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int i) {
        if (i % 90 == 0) {
            int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
            Integer valueOf = Integer.valueOf(attributeInt);
            List list = f4349y;
            int i2 = 0;
            if (list.contains(valueOf)) {
                int indexOf = ((i / 90) + list.indexOf(Integer.valueOf(attributeInt))) % 4;
                if (indexOf < 0) {
                    i2 = 4;
                }
                i2 = ((Integer) list.get(indexOf + i2)).intValue();
            } else {
                Integer valueOf2 = Integer.valueOf(attributeInt);
                List list2 = f4350z;
                if (list2.contains(valueOf2)) {
                    int indexOf2 = ((i / 90) + list2.indexOf(Integer.valueOf(attributeInt))) % 4;
                    if (indexOf2 < 0) {
                        i2 = 4;
                    }
                    i2 = ((Integer) list2.get(indexOf2 + i2)).intValue();
                }
            }
            setAttribute(TAG_ORIENTATION, Integer.toString(i2));
            return;
        }
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    /* renamed from: s */
    public final void m1125s(ta0 ta0Var) {
        m1124r(ta0Var);
        HashMap[] hashMapArr = this.f4356f;
        if (((va0) hashMapArr[0].get(TAG_RW2_JPG_FROM_RAW)) != null) {
            m1119m(ta0Var, this.f4370t, 5);
        }
        va0 va0Var = (va0) hashMapArr[0].get(TAG_RW2_ISO);
        va0 va0Var2 = (va0) hashMapArr[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (va0Var != null && va0Var2 == null) {
            hashMapArr[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, va0Var);
        }
    }

    public void saveAttributes() {
        int i;
        File file;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        File file2;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream2;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream2;
        if (this.f4371u && ((i = this.f4354d) == 4 || i == 13 || i == 14)) {
            if (this.f4352b == null && this.f4351a == null) {
                throw new IOException("ExifInterface does not support saving attributes for the current input.");
            }
            this.f4372v = true;
            this.f4364n = getThumbnail();
            InputStream inputStream2 = null;
            if (this.f4351a != null) {
                file = new File(this.f4351a);
            } else {
                file = null;
            }
            try {
                if (this.f4351a != null) {
                    file2 = new File(this.f4351a + ".tmp");
                    if (file.renameTo(file2)) {
                        inputStream = null;
                        fileOutputStream = null;
                    } else {
                        throw new IOException("Couldn't rename to " + file2.getAbsolutePath());
                    }
                } else if (this.f4352b != null) {
                    file2 = File.createTempFile("temp", "tmp");
                    Os.lseek(this.f4352b, 0L, OsConstants.SEEK_SET);
                    inputStream = new FileInputStream(this.f4352b);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                    }
                    try {
                        m1098i(inputStream, fileOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        inputStream2 = inputStream;
                        try {
                            throw new IOException("Failed to copy original file to temp file", e);
                        } catch (Throwable th2) {
                            th = th2;
                            m1093d(inputStream2);
                            m1093d(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream2 = inputStream;
                        m1093d(inputStream2);
                        m1093d(fileOutputStream);
                        throw th;
                    }
                } else {
                    inputStream = null;
                    file2 = null;
                    fileOutputStream = null;
                }
                m1093d(inputStream);
                m1093d(fileOutputStream);
                try {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    if (this.f4351a != null) {
                        fileOutputStream2 = new FileOutputStream(this.f4351a);
                    } else {
                        FileDescriptor fileDescriptor = this.f4352b;
                        if (fileDescriptor != null) {
                            Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_SET);
                            fileOutputStream2 = new FileOutputStream(this.f4352b);
                        } else {
                            fileOutputStream2 = null;
                        }
                    }
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream2);
                    } catch (Exception e3) {
                        e = e3;
                        bufferedOutputStream = null;
                        inputStream2 = bufferedInputStream;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    bufferedOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = null;
                }
                try {
                    int i2 = this.f4354d;
                    if (i2 == 4) {
                        m1108I(bufferedInputStream, bufferedOutputStream2);
                    } else if (i2 == 13) {
                        m1109J(bufferedInputStream, bufferedOutputStream2);
                    } else if (i2 == 14) {
                        m1110K(bufferedInputStream, bufferedOutputStream2);
                    }
                    m1093d(bufferedInputStream);
                    m1093d(bufferedOutputStream2);
                    file2.delete();
                    this.f4364n = null;
                } catch (Exception e5) {
                    inputStream2 = bufferedInputStream;
                    bufferedOutputStream = bufferedOutputStream2;
                    e = e5;
                    try {
                        if (this.f4351a != null && !file2.renameTo(file)) {
                            throw new IOException("Couldn't restore original file: " + file.getAbsolutePath());
                        }
                        throw new IOException("Failed to save new file", e);
                    } catch (Throwable th6) {
                        th = th6;
                        m1093d(inputStream2);
                        m1093d(bufferedOutputStream);
                        file2.delete();
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    bufferedOutputStream = bufferedOutputStream2;
                    inputStream2 = bufferedInputStream;
                    m1093d(inputStream2);
                    m1093d(bufferedOutputStream);
                    file2.delete();
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
        } else {
            throw new IOException("ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats.");
        }
    }

    public void setAltitude(double d) {
        String str;
        if (d >= 0.0d) {
            str = "0";
        } else {
            str = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        }
        setAttribute(TAG_GPS_ALTITUDE, new xa0(Math.abs(d)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:65:0x0194. Please report as an issue. */
    public void setAttribute(@NonNull String str, @Nullable String str2) {
        wa0 wa0Var;
        boolean z;
        String str3;
        int i;
        int i2;
        va0 va0Var;
        String str4;
        String str5 = str;
        String str6 = str2;
        int i3 = 0;
        int i4 = 1;
        if (str5 != null) {
            boolean equals = TAG_ISO_SPEED_RATINGS.equals(str5);
            boolean z2 = f4348x;
            String str7 = "ExifInterface";
            if (equals) {
                if (z2) {
                    Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str5 = TAG_PHOTOGRAPHIC_SENSITIVITY;
            }
            int i5 = 2;
            if (str6 != null && f4341d0.contains(str5)) {
                if (str5.equals(TAG_GPS_TIMESTAMP)) {
                    Matcher matcher = f4347j0.matcher(str6);
                    if (!matcher.find()) {
                        Log.w("ExifInterface", "Invalid value for " + str5 + " : " + str6);
                        return;
                    }
                    str6 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                } else {
                    try {
                        str6 = new xa0(Double.parseDouble(str2)).toString();
                    } catch (NumberFormatException unused) {
                        Log.w("ExifInterface", "Invalid value for " + str5 + " : " + str6);
                        return;
                    }
                }
            }
            int i6 = 0;
            while (i6 < f4335X.length) {
                if ((i6 != 4 || this.f4359i) && (wa0Var = (wa0) f4340c0[i6].get(str5)) != null) {
                    HashMap[] hashMapArr = this.f4356f;
                    if (str6 == null) {
                        hashMapArr[i6].remove(str5);
                    } else {
                        Pair m1100v = m1100v(str6);
                        int intValue = ((Integer) m1100v.first).intValue();
                        int i7 = -1;
                        int i8 = wa0Var.f28114c;
                        if (i8 != intValue && i8 != ((Integer) m1100v.second).intValue()) {
                            int i9 = wa0Var.f28115d;
                            if (i9 != -1 && (i9 == ((Integer) m1100v.first).intValue() || i9 == ((Integer) m1100v.second).intValue())) {
                                i8 = i9;
                            } else if (i8 != i4 && i8 != 7 && i8 != i5) {
                                if (z2) {
                                    StringBuilder m7065u = AbstractC1726qj.m7065u("Given tag (", str5, ") value didn't match with one of expected formats: ");
                                    String[] strArr = f4331T;
                                    m7065u.append(strArr[i8]);
                                    String str8 = "";
                                    if (i9 == -1) {
                                        str4 = "";
                                    } else {
                                        str4 = ", " + strArr[i9];
                                    }
                                    m7065u.append(str4);
                                    m7065u.append(" (guess: ");
                                    m7065u.append(strArr[((Integer) m1100v.first).intValue()]);
                                    if (((Integer) m1100v.second).intValue() != -1) {
                                        str8 = ", " + strArr[((Integer) m1100v.second).intValue()];
                                    }
                                    m7065u.append(str8);
                                    m7065u.append(")");
                                    Log.d(str7, m7065u.toString());
                                }
                            }
                        }
                        int[] iArr = f4332U;
                        switch (i8) {
                            case 1:
                                z = z2;
                                str3 = str7;
                                HashMap hashMap = hashMapArr[i6];
                                i = 1;
                                if (str6.length() == 1) {
                                    i2 = 0;
                                    if (str6.charAt(0) >= '0' && str6.charAt(0) <= '1') {
                                        va0Var = new va0(new byte[]{(byte) (str6.charAt(0) - '0')}, 1, 1);
                                        hashMap.put(str5, va0Var);
                                        break;
                                    }
                                } else {
                                    i2 = 0;
                                }
                                byte[] bytes = str6.getBytes(f4343f0);
                                va0Var = new va0(bytes, 1, bytes.length);
                                hashMap.put(str5, va0Var);
                                break;
                            case 2:
                            case 7:
                                z = z2;
                                str3 = str7;
                                hashMapArr[i6].put(str5, va0.m7886a(str6));
                                i2 = 0;
                                i = 1;
                                break;
                            case 3:
                                z = z2;
                                str3 = str7;
                                String[] split = str6.split(",", -1);
                                int[] iArr2 = new int[split.length];
                                for (int i10 = 0; i10 < split.length; i10++) {
                                    iArr2[i10] = Integer.parseInt(split[i10]);
                                }
                                hashMapArr[i6].put(str5, va0.m7891f(iArr2, this.f4358h));
                                i2 = 0;
                                i = 1;
                                break;
                            case 4:
                                z = z2;
                                str3 = str7;
                                String[] split2 = str6.split(",", -1);
                                long[] jArr = new long[split2.length];
                                for (int i11 = 0; i11 < split2.length; i11++) {
                                    jArr[i11] = Long.parseLong(split2[i11]);
                                }
                                hashMapArr[i6].put(str5, va0.m7888c(jArr, this.f4358h));
                                i2 = 0;
                                i = 1;
                                break;
                            case 5:
                                z = z2;
                                str3 = str7;
                                int i12 = -1;
                                String[] split3 = str6.split(",", -1);
                                xa0[] xa0VarArr = new xa0[split3.length];
                                int i13 = 0;
                                while (i13 < split3.length) {
                                    String[] split4 = split3[i13].split("/", i12);
                                    xa0VarArr[i13] = new xa0((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                    i13++;
                                    i12 = -1;
                                }
                                hashMapArr[i6].put(str5, va0.m7889d(xa0VarArr, this.f4358h));
                                i2 = 0;
                                i = 1;
                                break;
                            case 6:
                            case 8:
                            case 11:
                            default:
                                if (z2) {
                                    Log.d(str7, "Data format isn't one of expected formats: " + i8);
                                    break;
                                }
                                break;
                            case 9:
                                z = z2;
                                str3 = str7;
                                String[] split5 = str6.split(",", -1);
                                int length = split5.length;
                                int[] iArr3 = new int[length];
                                for (int i14 = 0; i14 < split5.length; i14++) {
                                    iArr3[i14] = Integer.parseInt(split5[i14]);
                                }
                                HashMap hashMap2 = hashMapArr[i6];
                                ByteOrder byteOrder = this.f4358h;
                                ByteBuffer wrap = ByteBuffer.wrap(new byte[iArr[9] * length]);
                                wrap.order(byteOrder);
                                for (int i15 = 0; i15 < length; i15++) {
                                    wrap.putInt(iArr3[i15]);
                                }
                                hashMap2.put(str5, new va0(wrap.array(), 9, length));
                                i2 = 0;
                                i = 1;
                                break;
                            case 10:
                                String[] split6 = str6.split(",", -1);
                                int length2 = split6.length;
                                xa0[] xa0VarArr2 = new xa0[length2];
                                int i16 = i3;
                                while (i16 < split6.length) {
                                    String[] split7 = split6[i16].split("/", i7);
                                    xa0VarArr2[i16] = new xa0((long) Double.parseDouble(split7[i3]), (long) Double.parseDouble(split7[1]));
                                    i16++;
                                    str7 = str7;
                                    z2 = z2;
                                    i3 = 0;
                                    i7 = -1;
                                }
                                z = z2;
                                str3 = str7;
                                HashMap hashMap3 = hashMapArr[i6];
                                ByteOrder byteOrder2 = this.f4358h;
                                ByteBuffer wrap2 = ByteBuffer.wrap(new byte[iArr[10] * length2]);
                                wrap2.order(byteOrder2);
                                for (int i17 = 0; i17 < length2; i17++) {
                                    xa0 xa0Var = xa0VarArr2[i17];
                                    wrap2.putInt((int) xa0Var.f28485a);
                                    wrap2.putInt((int) xa0Var.f28486b);
                                }
                                hashMap3.put(str5, new va0(wrap2.array(), 10, length2));
                                i2 = 0;
                                i = 1;
                                break;
                            case 12:
                                String[] split8 = str6.split(",", -1);
                                int length3 = split8.length;
                                double[] dArr = new double[length3];
                                for (int i18 = i3; i18 < split8.length; i18 += i4) {
                                    dArr[i18] = Double.parseDouble(split8[i18]);
                                }
                                HashMap hashMap4 = hashMapArr[i6];
                                ByteOrder byteOrder3 = this.f4358h;
                                ByteBuffer wrap3 = ByteBuffer.wrap(new byte[iArr[12] * length3]);
                                wrap3.order(byteOrder3);
                                for (int i19 = i3; i19 < length3; i19 += i4) {
                                    wrap3.putDouble(dArr[i19]);
                                }
                                hashMap4.put(str5, new va0(wrap3.array(), 12, length3));
                                break;
                        }
                        i6 += i;
                        i3 = i2;
                        i4 = i;
                        str7 = str3;
                        z2 = z;
                        i5 = 2;
                    }
                }
                i = i4;
                z = z2;
                str3 = str7;
                i2 = i3;
                i6 += i;
                i3 = i2;
                i4 = i;
                str7 = str3;
                z2 = z;
                i5 = 2;
            }
            return;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDateTime(long j) {
        setAttribute(TAG_DATETIME, f4330S.format(new Date(j)));
        setAttribute(TAG_SUBSEC_TIME, Long.toString(j % 1000));
    }

    public void setGpsInfo(Location location) {
        if (location == null) {
            return;
        }
        setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
        setLatLong(location.getLatitude(), location.getLongitude());
        setAltitude(location.getAltitude());
        setAttribute(TAG_GPS_SPEED_REF, "K");
        setAttribute(TAG_GPS_SPEED, new xa0((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1L))) / 1000.0f).toString());
        String[] split = f4330S.format(new Date(location.getTime())).split("\\s+", -1);
        setAttribute(TAG_GPS_DATESTAMP, split[0]);
        setAttribute(TAG_GPS_TIMESTAMP, split[1]);
    }

    public void setLatLong(double d, double d2) {
        String str;
        String str2;
        if (d >= -90.0d && d <= 90.0d && !Double.isNaN(d)) {
            if (d2 >= -180.0d && d2 <= 180.0d && !Double.isNaN(d2)) {
                if (d >= 0.0d) {
                    str = "N";
                } else {
                    str = LATITUDE_SOUTH;
                }
                setAttribute(TAG_GPS_LATITUDE_REF, str);
                setAttribute(TAG_GPS_LATITUDE, m1094e(Math.abs(d)));
                if (d2 >= 0.0d) {
                    str2 = LONGITUDE_EAST;
                } else {
                    str2 = LONGITUDE_WEST;
                }
                setAttribute(TAG_GPS_LONGITUDE_REF, str2);
                setAttribute(TAG_GPS_LONGITUDE, m1094e(Math.abs(d2)));
                return;
            }
            throw new IllegalArgumentException("Longitude value " + d2 + " is not valid.");
        }
        throw new IllegalArgumentException("Latitude value " + d + " is not valid.");
    }

    /* renamed from: t */
    public final void m1126t(ta0 ta0Var) {
        byte[] bArr = f4344g0;
        ta0Var.skipBytes(bArr.length);
        byte[] bArr2 = new byte[ta0Var.f26741a.available()];
        ta0Var.readFully(bArr2);
        this.f4366p = bArr.length;
        m1105F(0, bArr2);
    }

    /* renamed from: u */
    public final void m1127u(ta0 ta0Var) {
        if (f4348x) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + ta0Var);
        }
        ta0Var.f26742b = ByteOrder.LITTLE_ENDIAN;
        ta0Var.skipBytes(f4322K.length);
        int readInt = ta0Var.readInt() + 8;
        int skipBytes = ta0Var.skipBytes(f4323L.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (ta0Var.read(bArr) == 4) {
                    int readInt2 = ta0Var.readInt();
                    int i = skipBytes + 8;
                    if (Arrays.equals(f4324M, bArr)) {
                        byte[] bArr2 = new byte[readInt2];
                        if (ta0Var.read(bArr2) == readInt2) {
                            this.f4366p = i;
                            m1105F(0, bArr2);
                            this.f4366p = i;
                            return;
                        } else {
                            throw new IOException("Failed to read given length for given PNG chunk type: " + m1091b(bArr));
                        }
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    int i2 = i + readInt2;
                    if (i2 == readInt) {
                        return;
                    }
                    if (i2 <= readInt) {
                        int skipBytes2 = ta0Var.skipBytes(readInt2);
                        if (skipBytes2 == readInt2) {
                            skipBytes = i + skipBytes2;
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        throw new IOException("Encountered WebP file with invalid chunk size");
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    /* renamed from: w */
    public final void m1128w(ta0 ta0Var, HashMap hashMap) {
        va0 va0Var = (va0) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        va0 va0Var2 = (va0) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (va0Var != null && va0Var2 != null) {
            int m7893h = va0Var.m7893h(this.f4358h);
            int m7893h2 = va0Var2.m7893h(this.f4358h);
            if (this.f4354d == 7) {
                m7893h += this.f4367q;
            }
            int min = Math.min(m7893h2, ta0Var.f26743c - m7893h);
            if (m7893h > 0 && min > 0) {
                this.f4359i = true;
                int i = this.f4366p + m7893h;
                this.f4362l = i;
                this.f4363m = min;
                if (this.f4351a == null && this.f4353c == null && this.f4352b == null) {
                    byte[] bArr = new byte[min];
                    ta0Var.m7468a(i);
                    ta0Var.readFully(bArr);
                    this.f4364n = bArr;
                }
            }
            if (f4348x) {
                Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + m7893h + ", length: " + min);
            }
        }
    }

    /* renamed from: x */
    public final void m1129x(String str) {
        FileInputStream fileInputStream;
        if (str != null) {
            FileInputStream fileInputStream2 = null;
            this.f4353c = null;
            this.f4351a = str;
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (m1101y(fileInputStream.getFD())) {
                    this.f4352b = fileInputStream.getFD();
                } else {
                    this.f4352b = null;
                }
                m1102A(fileInputStream);
                m1093d(fileInputStream);
                return;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                m1093d(fileInputStream2);
                throw th;
            }
        }
        throw new NullPointerException("filename cannot be null");
    }

    /* renamed from: z */
    public final boolean m1130z(HashMap hashMap) {
        va0 va0Var = (va0) hashMap.get(TAG_IMAGE_LENGTH);
        va0 va0Var2 = (va0) hashMap.get(TAG_IMAGE_WIDTH);
        if (va0Var != null && va0Var2 != null) {
            int m7893h = va0Var.m7893h(this.f4358h);
            int m7893h2 = va0Var2.m7893h(this.f4358h);
            if (m7893h <= 512 && m7893h2 <= 512) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Nullable
    public double[] getLatLong() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{m1095f(attribute, attribute2), m1095f(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            Log.w("ExifInterface", "Latitude/longitude values are not parsable. ".concat("latValue=" + attribute + ", latRef=" + attribute2 + ", lngValue=" + attribute3 + ", lngRef=" + attribute4));
            return null;
        }
    }

    public ExifInterface(@NonNull String str) {
        wa0[][] wa0VarArr = f4335X;
        this.f4356f = new HashMap[wa0VarArr.length];
        this.f4357g = new HashSet(wa0VarArr.length);
        this.f4358h = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            m1129x(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    public ExifInterface(@NonNull FileDescriptor fileDescriptor) {
        boolean z;
        FileInputStream fileInputStream;
        Throwable th;
        wa0[][] wa0VarArr = f4335X;
        this.f4356f = new HashMap[wa0VarArr.length];
        this.f4357g = new HashSet(wa0VarArr.length);
        this.f4358h = ByteOrder.BIG_ENDIAN;
        if (fileDescriptor != null) {
            this.f4353c = null;
            this.f4351a = null;
            if (m1101y(fileDescriptor)) {
                this.f4352b = fileDescriptor;
                try {
                    fileDescriptor = Os.dup(fileDescriptor);
                    z = true;
                } catch (Exception e) {
                    throw new IOException("Failed to duplicate file descriptor", e);
                }
            } else {
                this.f4352b = null;
                z = false;
            }
            try {
                fileInputStream = new FileInputStream(fileDescriptor);
                try {
                    m1102A(fileInputStream);
                    m1093d(fileInputStream);
                    if (z) {
                        m1092c(fileDescriptor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    m1093d(fileInputStream);
                    if (z) {
                        m1092c(fileDescriptor);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        } else {
            throw new NullPointerException("fileDescriptor cannot be null");
        }
    }

    public ExifInterface(@NonNull InputStream inputStream) {
        this(inputStream, false);
    }

    public ExifInterface(@NonNull InputStream inputStream, int i) {
        this(inputStream, i == 1);
    }

    public ExifInterface(InputStream inputStream, boolean z) {
        wa0[][] wa0VarArr = f4335X;
        this.f4356f = new HashMap[wa0VarArr.length];
        this.f4357g = new HashSet(wa0VarArr.length);
        this.f4358h = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.f4351a = null;
            if (z) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                byte[] bArr = f4344g0;
                bufferedInputStream.mark(bArr.length);
                byte[] bArr2 = new byte[bArr.length];
                bufferedInputStream.read(bArr2);
                bufferedInputStream.reset();
                for (int i = 0; i < bArr.length; i++) {
                    if (bArr2[i] != bArr[i]) {
                        Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                        return;
                    }
                }
                this.f4355e = true;
                this.f4353c = null;
                this.f4352b = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f4353c = (AssetManager.AssetInputStream) inputStream;
                this.f4352b = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (m1101y(fileInputStream.getFD())) {
                        this.f4353c = null;
                        this.f4352b = fileInputStream.getFD();
                    }
                }
                this.f4353c = null;
                this.f4352b = null;
            }
            m1102A(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
