resource "aws_iam_user" "uploader" {
  name = "tax-thiefs-web-uploader"
}

resource "aws_iam_access_key" "uploader-key" {
  user = "${aws_iam_user.uploader.name}"
}
