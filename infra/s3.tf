
data "aws_s3_bucket" "tax-thiefs-bucket" {
  bucket = "tax-thiefs.com"
}

resource "aws_s3_bucket_policy" "s3-policy" {
  bucket = "${data.aws_s3_bucket.tax-thiefs-bucket.id}"

  policy = <<POLICY
{
  "Version": "2012-10-17",
  "Id": "MYBUCKETPOLICY",
  "Statement": [
    {
      "Sid": "UploadAllow",
      "Effect": "Allow",
      "Principal": {
        "AWS": [
          "${aws_iam_user.uploader.arn}"
        ]
      },
      "Action": [
        "s3:PutObject",
        "s3:PutObjectAcl"
      ],
      "Resource": "arn:aws:s3:::tax-thiefs.com/*"
    }
  ]
}
POLICY
}
