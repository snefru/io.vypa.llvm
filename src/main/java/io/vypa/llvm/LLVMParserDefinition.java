package io.vypa.llvm;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import io.vypa.llvm.parser.LLVMParser;
import io.vypa.llvm.psi.LLVMTypes;
import io.vypa.llvm.psi.LLVMTypes.*;
import org.jetbrains.annotations.NotNull;

import static io.vypa.llvm.psi.LLVMTypes.*;

;

public class LLVMParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(COMMENT);
    public static final TokenSet STRING_LITERALS = TokenSet.create(STRING, CHAR_ARRAY_LITERAL, METADATA_STRING);
    public static final TokenSet NUMBERS = TokenSet.create(INTERGER_LITERAL, FLOAT_LITERAL);
    public static final TokenSet IDENTIFIERS = TokenSet.create(GLOBAL_IDENTIFIER, METADATA_IDENTIFIER);
    public static final TokenSet LOCAL_IDENTIFIERS = TokenSet.create(LOCAL_IDENTIFIER);
    public static final TokenSet LABEL = TokenSet.create(LABEL_ID);
    public static final TokenSet TYPE_REFERENCE = TokenSet.create(TYPE_LITERAL);
    public static final TokenSet BRACKETS = TokenSet.create(LEFT_BRACKET, RIGHT_BRACKET);
    public static final TokenSet PARENTHESES = TokenSet.create(LEFT_PARENTHESIS, RIGHT_PARENTHESIS);
    public static final TokenSet BRACES = TokenSet.create(LEFT_BRACE, RIGHT_BRACE, METADATA_LEFT_BRACE);
    public static final TokenSet COMMA = TokenSet.create(LLVMTypes.COMMA);
    public static final TokenSet KEYWORDS = TokenSet.create(
            ACQUIRE,
            ACQ_REL,
            ADD,
            ADDRSPACE,
            ADDRSPACECAST,
            ALIAS,
            ALIGN,
            ALIGNSTACK,
            ALLOCA,
            ALWAYSINLINE,
            AND,
            ANY,
            ANYREGCC,
            APPENDING,
            ARCP,
            ARGMEMONLY,
            ARM_AAPCSCC,
            ARM_AAPCS_VFPCC,
            ARM_APCSCC,
            ASHR,
            ASM,
            ATOMIC,
            ATOMICRMW,
            ATTRIBUTES,
            ATT_GROUP_ID,
            AVAILABLE_EXTERNALLY,
            BITCAST,
            BLOCKADDRESS,
            BR,
//            BRACKETS,
            BUILTIN,
            BYVAL,
            CALL,
            CALLER,
            CATCH,
            CATCHPAD,
            CATCHRET,
            CATCHSWITCH,
            CC,
            CCC,
//            CHAR_ARRAY_LITERAL,
            CLEANUP,
            CLEANUPPAD,
            CLEANUPRET,
            CMPXCHG,
            COLD,
            COLDCC,
            COMDAT_IDENTIFIER,
//            COMMA,
//            COMMENT,
            COMMON,
            CONSTANT,
            CONVERGENT,
            CXX_FAST_TLSCC,
            DATALAYOUT,
            DECIMAL_FPLITERAL,
            DECLARE,
            DEFAULT,
            DEFINE,
            DEPLIBS,
            DEREFERENCEABLE,
            DEREFERENCEABLE_OR_NULL,
            DIGIT,
            DISTINCT,
            DLLEXPORT,
            DLLIMPORT,
//            EQ,
            EXACT,
            EXACTMATCH,
            EXTERNAL,
            EXTERNALLY_INITIALIZED,
            EXTERN_WEAK,
            EXTRACTELEMENT,
            EXTRACTVALUE,
            FADD,
//            FALSE,
            FAST,
            FASTCC,
            FCMP,
            FDIV,
            FENCE,
            FILTER,
            FMUL,
            FPEXT,
            FPTOSI,
            FPTOUI,
            FPTRUNC,
            FREM,
            FROM,
            FSUB,
            GC,
            GETELEMENTPTR,
            GHCCC,
            GLOBAL,
//            GLOBAL_IDENTIFIER,
//            HEX_FP128LITERAL,
//            HEX_FP80LITERAL,
//            HEX_FPLITERAL,
//            HEX_HALF_LITERAL,
//            HEX_PPC128LITERAL,
            HHVMCC,
            HHVM_CCC,
            HIDDEN,
            ICMP,
            INACCESSIBLEMEMONLY,
            INACCESSIBLEMEM_OR_ARGMEMONLY,
            INALLOCA,
            INBOUNDS,
            INDIRECTBR,
            INITIALEXEC,
            INLINEHINT,
            INREG,
            INSERTELEMENT,
            INSERTVALUE,
            INTELDIALECT,
            INTEL_OCL_BICC,
//            INTERGER_LITERAL,
            INTERNAL,
            INTTOPTR,
            INVOKE,
            JUMPTABLE,
//            KEYWORD,
//            LABEL_ID,
            LANDINGPAD,
            LARGEST,
            LINKONCE,
            LINKONCE_ODR,
            LOAD,
            LOCALDYNAMIC,
            LOCALEXEC,
//            LOCAL_IDENTIFIER,
            LSHL,
            LSHR,
            MAX,
//            METADATA_IDENTIFIER,
//            METADATA_STRING,
            MIN,
            MINSIZE,
            MONOTONIC,
            MSP430_INTRCC,
            MUL,
            MUSTTAIL,
            NAKED,
            NAND,
            NE,
            NEST,
            NINF,
            NNAN,
            NOALIAS,
            NOBUILTIN,
            NOCAPTURE,
            NODUPLICATE,
            NODUPLICATES,
            NOIMPLICITFLOAT,
            NOINLINE,
            NONE,
            NONLAZYBIND,
            NONNULL,
            NORECURSE,
            NOREDZONE,
            NORETURN,
            NOTAIL,
            NOUNWIND,
            NSW,
            NSZ,
            NULL,
            NUW,
            OEQ,
            OGE,
            OGT,
            OLE,
            OLT,
            ONE,
            OPERATOR,
            OPTNONE,
            OPTSIZE,
            OR,
            ORD,
            PERSONALITY,
            PHI,
            PREFIX,
            PRESERVE_ALLCC,
            PRESERVE_MOSTCC,
            PRIVATE,
            PROLOGUE,
            PROTECTED,
            PTRTOINT,
            PTX_DEVICE,
            PTX_KERNEL,
            READNONE,
            READONLY,
            RELEASE,
            RESUME,
            RET,
            RETURNED,
            RETURNS_TWICE,
            SAFESTACK,
            SAMESIZE,
            SANITIZE_ADDRESS,
            SANITIZE_MEMORY,
            SANITIZE_THREAD,
            SDIV,
            SELECT,
            SEQ_CST,
            SEXT,
            SGE,
            SGT,
            SHL,
            SHUFFLEVECTOR,
            SIDEEFFECT,
            SIGNEXT,
            SINGLETHREAD,
            SITOFP,
            SLE,
            SLT,
            SPIR_FUNC,
            SPIR_KERNEL,
            SREM,
            SRET,
            SSP,
            SSPREQ,
            SSPSTRONG,
            STORE,
//            STRING,
            SUB,
            SWITCH,
            TAIL,
            TARGET,
            THREAD_LOCAL,
            THUNK,
            TO,
            TRIPLE,
            TRUE,
            TRUNC,
            UDIV,
            UEQ,
            UGE,
            UGT,
            UITOFP,
            ULE,
            ULT,
            UMAX,
            UMIN,
            UNDEF,
            UNE,
            UNNAMED_ADDR,
            UNO,
            UNORDERED,
            UNREACHABLE,
            UNWIND,
            UREM,
            UWTABLE,
            VA_ARG,
            VOID,
            VOLATILE,
            WEAK,
            WEAK_ODR,
            WEBKIT_JSCC,
            WITHIN,
            X86_64_SYSVCC,
            X86_64_WIN64CC,
            X86_FASTCALLCC,
            X86_INTRCC,
            X86_STDCALLCC,
            X86_THISCALLCC,
            X86_VECTORCALLCC,
            XCHG,
            XOR,
            ZEROEXT,
            ZEROINITIALIZER,
            ZEXT
    );
    public static final IFileElementType FILE = new IFileElementType(Language.findInstance(LLVMLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new LLVMLexerAdapter();
    }

    @Override
    @NotNull
    public TokenSet getWhitespaceTokens() {
        return LLVMParserDefinition.WHITE_SPACES;
    }

    @Override
    @NotNull
    public TokenSet getCommentTokens() {
        return LLVMParserDefinition.COMMENTS;
    }

    @Override
    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    @NotNull
    public PsiParser createParser(Project project) {
        return new LLVMParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return LLVMParserDefinition.FILE;
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new LLVMFile(viewProvider);
    }

    @Override
    public ParserDefinition.SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return ParserDefinition.SpaceRequirements.MAY;
    }

    @Override
    @NotNull
    public PsiElement createElement(ASTNode node) {
        return Factory.createElement(node);
    }
}