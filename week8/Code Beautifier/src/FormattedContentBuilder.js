
function FormattedContentBuilder(indentString) {
    this._lastOriginalPosition = 0;

    this._formattedContent = [];   
    this._formattedContentLength = 0;
    this._lastFormattedPosition = 0;

    this._mapping = {original: [0], formatted: [0]};  
    this._nestingLevel = 0; 
    this._indentString = indentString;
    this._cachedIndents = {}; 
    this._newLines = 0; 
        this._softSpace = false;    
    this._hardSpaces = 0;   
    this._enforceSpaceBetweenWords = true;  
}

FormattedContentBuilder.prototype = {
   
     setEnforceSpaceBetweenWords: function (value) {
        var oldValue = this._enforceSpaceBetweenWords;
        this._enforceSpaceBetweenWords = value;
        return oldValue;
    },
   
     addSoftSpace: function () {
        if (!this._hardSpaces) {
            this._softSpace = true;
        }
    },
        addHardSpace: function () {
        this._softSpace = false;
        ++this._hardSpaces;
    },
    
     increaseNestingLevel: function () {
        this._nestingLevel += 1;
    },
    decreaseNestingLevel: function () {
        if (this._nestingLevel > 0) {
            this._nestingLevel -= 1;
        }
    },
    
     addNewLine: function (noSquash) {
        // Avoid leading newlines. 避免引导换行
        if (!this._formattedContentLength) {
            return;
        }
        if (noSquash) {
            ++this._newLines;
        } else {
            this._newLines = this._newLines || 1;
        }
    },
    
     _indent: function () {

        var cachedValue = this._cachedIndents[this._nestingLevel];
        if (cachedValue) {
            return cachedValue;
        }
        
        var fullIndent = "";
        for (var i = 0; i < this._nestingLevel; ++i) {
            fullIndent += this._indentString;
        }

        
        if (this._nestingLevel <= 20) {
            this._cachedIndents[this._nestingLevel] = fullIndent;
        }
        return fullIndent;
    },
    
     _appendFormatting: function () {
        
        if (this._newLines) {
            for (var i = 0; i < this._newLines; ++i) {
                this._addText("\n");
            }
            this._addText(this._indent());
        } else if (this._softSpace) {    // 添加空白符
            this._addText(" ");
        }
        if (this._hardSpaces) {
            for (var i = 0; i < this._hardSpaces; ++i)
                this._addText(" ");
        }
        // 初始化
        this._newLines = 0;
        this._softSpace = false;
        this._hardSpaces = 0;
    },
    /**
     * 添加已经格式化的文本
     * @param text
     * @private
     */
     _addText: function (text) {
        this._formattedContent.push(text);
        this._formattedContentLength += text.length;
    },
    /**
     * 添加格式化分词内容
     * @param token
     * @param offset
     */
     addToken: function (token, offset) {
        var last = this._formattedContent[this._formattedContent.length - 1];
        // \w表示字符类（包括大小写字母，数字）
        // 添加空格
        if (this._enforceSpaceBetweenWords && last && /\w/.test(last[last.length - 1]) && /\w/.test(token)) {
            this.addSoftSpace();
        }
        this._appendFormatting();

        // Insert token. 插入token
        this._addMappingIfNeeded(offset);
        this._addText(token);
    },
    /**
     * 记录格式化过程中分词的位置信息
     * @param originalPosition
     * @private
     */
     _addMappingIfNeeded: function (originalPosition) {
        if (originalPosition - this._lastOriginalPosition === this._formattedContentLength - this._lastFormattedPosition) {
            return;
        }
        this._mapping.original.push(originalPosition);
        this._lastOriginalPosition = originalPosition;
        this._mapping.formatted.push(this._formattedContentLength);
        this._lastFormattedPosition = this._formattedContentLength;
    },
    /**
     *
     * @returns {{original: number[], formatted: number[]}|*}
     */
     mapping: function () {
        return this._mapping;
    },
    /**
     * 返回格式化后文本
     * @returns {string}
     */
     content: function () {
        return this._formattedContent.join("") + (this._newLines ? "\n" : "");
    }
};

module.exports = FormattedContentBuilder;