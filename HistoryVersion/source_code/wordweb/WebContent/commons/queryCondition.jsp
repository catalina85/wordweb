<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function() {
		$("a").each(function() {
			this.onclick = function() {
				var serializeVal = $(":hidden").serialize();
				var href = this.href + "&" + serializeVal;
				window.location.href = href;
				return false;
			};
		});
	});
</script>
<input type="hidden" name="nameFeatureOne"
	value="${param.nameFeatureOne }" />
<input type="hidden" name="nameFeatureTwo"
	value="${param.nameFeatureTwo }" />
<input type="hidden" name="nameFeatureThree"
	value="${param.nameFeatureThree }" />

<input type="hidden" name="meaningFeatureOne"
	value="${param.meaningFeatureOne }" />
<input type="hidden" name="meaningFeatureTwo"
	value="${param.meaningFeatureTwo }" />
<input type="hidden" name="meaningFeatureThree"
	value="${param.meaningFeatureThree }" />

<input type="hidden" name="mDate" value="${param.mDate }" />
<input type="hidden" name="mDateEnd" value="${param.mDateEnd }" />
<input type="hidden" name="listName" value="${param.listName }" />
<input type="hidden" name="listNameEnd" value="${param.listNameEnd }" />
<input type="hidden" name="backpath" value="${param.backpath }" />





