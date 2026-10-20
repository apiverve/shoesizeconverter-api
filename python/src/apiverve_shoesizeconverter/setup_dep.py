from setuptools import setup, find_packages

setup(
    name='apiverve_shoesizeconverter',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Shoe Size Converter translates footwear measurements across regional standards, including US, UK, Australian, Mexican, and Korean sizing systems. Provide a size, source region, and gender category to get equivalent sizes, with paid plans adding European, Japanese, and centimeter measurements.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/shoesizeconverter?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
