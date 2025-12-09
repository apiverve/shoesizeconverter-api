from setuptools import setup, find_packages

setup(
    name='apiverve_shoesizeconverter',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Shoe Size Converter is a tool for converting shoe sizes between US, UK, EU, CM, JP, AU, MX, and KR standards. It supports men, women, unisex, and child sizes.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
