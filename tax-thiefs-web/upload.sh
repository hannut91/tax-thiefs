npm run build
aws s3 cp build/ s3://tax-thiefs.com --recursive --acl public-read
