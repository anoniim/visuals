package net.solvetheriddle.processing.library


const val X = 0
const val Y = 1
const val Z = 2
const val JAVA2D = "processing.core.PGraphicsAndroid2D"
const val P2D = "processing.opengl.PGraphics2D"
const val P3D = "processing.opengl.PGraphics3D"
const val OPENGL = "processing.opengl.PGraphics3D"
const val STEREO = "processing.vr.PGraphicsVRStereo"
const val MONO = "processing.vr.PGraphicsVRMono"
const val OTHER = 0
const val WINDOWS = 1
const val MACOSX = 2
const val LINUX = 3
val platformNames = arrayOf("other", "windows", "macosx", "linux")
const val EPSILON = 1.0E-4f
const val MAX_FLOAT = 3.4028235E38f
const val MIN_FLOAT = -3.4028235E38f
const val MAX_INT = 2147483647
const val MIN_INT = -2147483648
const val VERTEX = 0
const val BEZIER_VERTEX = 1
const val QUADRATIC_VERTEX = 2
const val CURVE_VERTEX = 3
const val BREAK = 4

@Deprecated("")
const val QUAD_BEZIER_VERTEX = 2
const val PI = 3.1415927f
const val HALF_PI = 1.5707964f
const val THIRD_PI = 1.0471976f
const val QUARTER_PI = 0.7853982f
const val TWO_PI = 6.2831855f
const val TAU = 6.2831855f
const val DEG_TO_RAD = 0.017453292f
const val RAD_TO_DEG = 57.295776f
const val WHITESPACE = " \t\n\r "
const val RGB = 1
const val ARGB = 2
const val HSB = 3
const val ALPHA = 4
const val CMYK = 5
const val YUV420 = 6
const val TIFF = 0
const val TARGA = 1
const val JPEG = 2
const val GIF = 3
const val BLUR = 11
const val GRAY = 12
const val INVERT = 13
const val OPAQUE = 14
const val POSTERIZE = 15
const val THRESHOLD = 16
const val ERODE = 17
const val DILATE = 18
const val REPLACE = 0
const val BLEND = 1
const val ADD = 2
const val SUBTRACT = 4
const val LIGHTEST = 8
const val DARKEST = 16
const val DIFFERENCE = 32
const val EXCLUSION = 64
const val MULTIPLY = 128
const val SCREEN = 256
const val OVERLAY = 512
const val HARD_LIGHT = 1024
const val SOFT_LIGHT = 2048
const val DODGE = 4096
const val BURN = 8192
const val CHATTER = 0
const val COMPLAINT = 1
const val PROBLEM = 2
const val PROJECTION = 0
const val MODELVIEW = 1
const val CUSTOM = 0
const val ORTHOGRAPHIC = 2
const val PERSPECTIVE = 3
const val GROUP = 0
const val POINT = 2
const val POINTS = 3
const val LINE = 4
const val LINES = 5
const val LINE_STRIP = 50
const val LINE_LOOP = 51
const val TRIANGLE = 8
const val TRIANGLES = 9
const val TRIANGLE_STRIP = 10
const val TRIANGLE_FAN = 11
const val QUAD = 16
const val QUADS = 17
const val QUAD_STRIP = 18
const val POLYGON = 20
const val PATH = 21
const val RECT = 30
const val ELLIPSE = 31
const val ARC = 32
const val SPHERE = 40
const val BOX = 41
const val OPEN = 1
const val CLOSE = 2
const val CORNER = 0
const val CORNERS = 1
const val RADIUS = 2

@Deprecated("")
const val CENTER_RADIUS = 2
const val CENTER = 3
const val DIAMETER = 3

@Deprecated("")
const val CENTER_DIAMETER = 3
const val CHORD = 2
const val PIE = 3
const val BASELINE = 0
const val TOP = 101
const val BOTTOM = 102
const val NORMAL = 1
const val IMAGE = 2
const val CLAMP = 0
const val REPEAT = 1
const val MODEL = 4
const val SHAPE = 5
const val SQUARE = 1
const val ROUND = 2
const val PROJECT = 4
const val MITER = 8
const val BEVEL = 32
const val AMBIENT = 0
const val DIRECTIONAL = 1
const val SPOT = 3
const val BACKSPACE = 'C'
const val TAB = '='
const val ENTER = 'B'
const val RETURN = 'B'
const val ESC = 'o'
const val DELETE = 'C'
const val CODED = 65535
const val UP = 19
const val DOWN = 20
const val LEFT = 21
const val RIGHT = 22
const val BACK = 4
const val MENU = 82
const val DPAD = 23
const val SHIFT = 59
const val PORTRAIT = 1
const val LANDSCAPE = 2

@Deprecated("")
const val ENABLE_NATIVE_FONTS = 1

@Deprecated("")
const val DISABLE_NATIVE_FONTS = -1
const val DISABLE_DEPTH_TEST = 2
const val ENABLE_DEPTH_TEST = -2
const val ENABLE_DEPTH_SORT = 3
const val DISABLE_DEPTH_SORT = -3
const val DISABLE_OPENGL_ERRORS = 4
const val ENABLE_OPENGL_ERRORS = -4
const val DISABLE_DEPTH_MASK = 5
const val ENABLE_DEPTH_MASK = -5
const val DISABLE_OPTIMIZED_STROKE = 6
const val ENABLE_OPTIMIZED_STROKE = -6
const val ENABLE_STROKE_PERSPECTIVE = 7
const val DISABLE_STROKE_PERSPECTIVE = -7
const val DISABLE_TEXTURE_MIPMAPS = 8
const val ENABLE_TEXTURE_MIPMAPS = -8
const val ENABLE_STROKE_PURE = 9
const val DISABLE_STROKE_PURE = -9
const val ENABLE_BUFFER_READING = 10
const val DISABLE_BUFFER_READING = -10
const val DISABLE_KEY_REPEAT = 11
const val ENABLE_KEY_REPEAT = -11
const val DISABLE_ASYNC_SAVEFRAME = 12
const val ENABLE_ASYNC_SAVEFRAME = -12
const val HINT_COUNT = 13
const val ERROR_BACKGROUND_IMAGE_SIZE = "background image must be the same size as your application"
const val ERROR_BACKGROUND_IMAGE_FORMAT = "background images should be RGB or ARGB"
const val ERROR_TEXTFONT_NULL_PFONT = "A null PFont was passed to textFont()"
const val ERROR_PUSHMATRIX_OVERFLOW = "Too many calls to pushMatrix()."
const val ERROR_PUSHMATRIX_UNDERFLOW = "Too many calls to popMatrix(), and not enough to pushMatrix()."